package com.example.turkmedya.data.dto

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("categoryId") val categoryId: String,
    @SerializedName("title") val title: String,
    @SerializedName("slug") val slug: String
)
