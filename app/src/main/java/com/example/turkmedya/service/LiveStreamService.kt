package com.example.turkmedya.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.turkmedya.R
import com.example.turkmedya.ui.activity.MainActivity
import com.example.turkmedya.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
// Uygulamanın arka planınında canlı yayın oynatmak için servis sınıfı oluşturuldu.
class LiveStreamService : Service() {

    // ExoPlayer nesnesine Hilt ile field injection yapıldı.
    @Inject
    lateinit var exoPlayer: ExoPlayer

    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): LiveStreamService = this@LiveStreamService
    }
    // Servis ilk oluşturulduğunda çalışır.
    override fun onCreate() {
        super.onCreate()
        // Canlı yayın URL'sini kullanarak bir MediaItem nesnesi oluşturuluyor.
        val mediaItem = MediaItem.fromUri(Constants.VIDEO_URL)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
        startForeground(Constants.NOTIFICATION_ID, createNotification())
    }
    //Kullanıcıya gösterilecek olan bildirimi oluşturur.
    private fun createNotification(): Notification {
        createNotificationChannel()
        // Oynat butonuna tıklandığında çalışacak olan Intent oluşturuluyor.
        val playIntent = Intent(this, LiveStreamService::class.java).apply {
            action = "ACTION_PLAY"
        }
        val playPendingIntent = PendingIntent.getService(
            this, 0, playIntent, PendingIntent.FLAG_IMMUTABLE
        )
        // Duraklat butonuna tıklandığında çalışacak olan Intent oluşturuluyor.
        val pauseIntent = Intent(this, LiveStreamService::class.java).apply {
            action = "ACTION_PAUSE"
        }
        val pausePendingIntent = PendingIntent.getService(
            this, 0, pauseIntent, PendingIntent.FLAG_IMMUTABLE
        )

        // Bildirime tıklandığında kullanıcıyı uygulamaya yönlendirecek yapı
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, Constants.CHANNEL_ID)
            .setContentTitle("Canlı Yayın Oynatılıyor")
            .setContentText("TV24 canlı yayını oynatılıyor.")
            .setSmallIcon(R.drawable.ic_turkmedya_dijital)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_turkmedya_dijital))
            .addAction(0, "Duraklat", pausePendingIntent)
            .addAction(0, "Oynat", playPendingIntent)
            .setContentIntent(pendingIntent)
            .build()
    }
    // Android Oreo ve üzeri sürümlerde bildirim kanalı oluşturmak zorunlu olduğundan kontrolümüzü yapıyoruz.
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Constants.CHANNEL_ID,
                Constants.CHANNEL_ID,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "ACTION_PLAY" -> {
                exoPlayer.prepare()
                exoPlayer.play()
            }
            "ACTION_PAUSE" -> exoPlayer.pause()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer.release()
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }
    // Servisi manuel olarak durdurmak için bir yardımcı fonksiyon
    fun stopService(){
        stopSelf()
    }
}