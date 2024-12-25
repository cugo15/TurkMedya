package com.example.turkmedya.domain.usecase

import com.example.turkmedya.data.dto.NewsItem
import com.example.turkmedya.domain.model.FilteredNews
import com.example.turkmedya.domain.repository.NewsRepository
import com.example.turkmedya.utils.toFilteredNewsList
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend fun execute(): Result<List<FilteredNews>> {
        return try {
            val response = repository.getNews()
            if (response.isSuccessful) {
                val newsResponse = response.body()
                val allItems = mutableListOf<NewsItem>()

                // API'den gelen veriyi işleyip itemList'e ekleyin
                newsResponse?.data?.forEach { section ->
                    allItems.addAll(section.itemList)
                }
                val filteredNewsList = allItems.toFilteredNewsList()

                Result.success(filteredNewsList)
            } else {
                Result.failure(Exception("API Error: ${response.errorBody()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
