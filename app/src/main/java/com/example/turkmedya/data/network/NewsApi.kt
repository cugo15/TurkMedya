package com.example.turkmedya.data.network

import com.example.turkmedya.data.dto.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("anasayfa.json")
    suspend fun getNews(): Response<NewsResponse>
}