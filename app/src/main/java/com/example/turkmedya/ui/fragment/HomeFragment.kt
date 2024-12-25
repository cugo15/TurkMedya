
package com.example.turkmedya.ui.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turkmedya.databinding.FragmentHomeBinding
import com.example.turkmedya.domain.model.FilteredNews
import com.example.turkmedya.service.LiveStreamService
import com.example.turkmedya.ui.adapter.NewsAdapter
import com.example.turkmedya.ui.fragment.base.BaseFragment
import com.example.turkmedya.ui.viewmodel.HomeViewModel

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var playerView: PlayerView
    private var liveStreamService: LiveStreamService? = null
    private var isBound = false
    private val homeViewModel: HomeViewModel by viewModels()
    @Inject
    lateinit var exoPlayer: ExoPlayer

    // Service'e bağlanmak için kullanılan ServiceConnection
    private val connection = object : ServiceConnection {
        // Service'e bağlandığında çağrılır
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // Service'den LocalBinder'ı al
            val binder = service as LiveStreamService.LocalBinder
            // Service örneğini al
            liveStreamService = binder.getService()
            // Bağlantı kuruldu
            isBound = true
            // PlayerView'a ExoPlayer'ı bağla
            playerView.player = liveStreamService?.exoPlayer
        }

        // Service ile bağlantı kesildiğinde çağrılır
        override fun onServiceDisconnected(arg0: ComponentName) {
            // Bağlantı kesildi
            isBound = false
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerView = binding.playerView

        // Service'i başlat
        val intent = Intent(requireContext(), LiveStreamService::class.java)
        requireContext().startService(intent)

        // Service'e bağlan
        bindToService()
        homeViewModel.fetchNews()
        homeViewModel.itemList.observe(viewLifecycleOwner, Observer { itemList ->
            setupRecyclerView(itemList)
        })
    }

    private fun setupRecyclerView(newsList: List<FilteredNews>) {
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvNews.adapter = NewsAdapter(newsList) {clickedNews ->
            val position = newsList.indexOf(clickedNews)
            val newList = newsList.subList(position, newsList.size)
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(newList.toTypedArray()).also { findNavController().navigate(it) }
        }
    }

    private fun bindToService() {
        Intent(requireContext(), LiveStreamService::class.java).also { intent ->
            requireContext().bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        // Service'e bağlıysa
        if (isBound) {
            // Service ile bağlantıyı kes
            requireContext().unbindService(connection)
            // Bağlantı kesildi
            isBound = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // PlayerView'ı temizle
        playerView.player = null
        liveStreamService?.stopService()
    }
}