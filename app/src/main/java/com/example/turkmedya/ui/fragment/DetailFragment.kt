package com.example.turkmedya.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.turkmedya.databinding.FragmentDetailBinding
import com.example.turkmedya.domain.model.FilteredNews
import com.example.turkmedya.ui.adapter.NewsDetailAdapter
import com.example.turkmedya.ui.fragment.base.BaseFragment


class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val news = DetailFragmentArgs.fromBundle(requireArguments()).news
        setupRecyclerView(news)
    }
    private fun setupRecyclerView(newsList: Array<FilteredNews>) {
        binding.rvDetail.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDetail.adapter = NewsDetailAdapter(newsList)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvDetail)
    }



}