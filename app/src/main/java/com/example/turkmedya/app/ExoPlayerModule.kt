package com.example.turkmedya.app

import android.app.Application
import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExoPlayerModule {
    @Provides
    @Singleton  // Bu context'in uygulama boyunca sadece bir kere oluşturulmasını sağlıyoruz.
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
    @Provides  // Canlı yayın için ExoPlayer sağlanıyor..
    fun provideExoPlayer(context: Context): ExoPlayer {
        return ExoPlayer.Builder(context).build()
    }

}