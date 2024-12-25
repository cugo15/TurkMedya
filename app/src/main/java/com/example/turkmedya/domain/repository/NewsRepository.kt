package com.example.turkmedya.domain.repository

import com.example.turkmedya.data.network.NewsApi
import com.example.turkmedya.data.dto.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {
    suspend fun getNews(): Response<NewsResponse> {
        return newsApi.getNews()
    }
}