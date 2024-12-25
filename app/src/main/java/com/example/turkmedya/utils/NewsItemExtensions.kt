package com.example.turkmedya.utils

import com.example.turkmedya.data.dto.NewsItem
import com.example.turkmedya.domain.model.FilteredNews

//İşimize yaramayacak veriler filtreleniyor
fun NewsItem.toFilteredNews(): FilteredNews {
    return FilteredNews(
        title = this.title,
        imageUrl = this.imageUrl,
        shortText = this.shortText,
        publishDate = this.publishDate,
        category = this.category
    )
}
fun List<NewsItem>.toFilteredNewsList(): List<FilteredNews> {
    return this.map { it.toFilteredNews() }
}
