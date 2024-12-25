package com.example.turkmedya.data.dto

import com.google.gson.annotations.SerializedName

    data class NewsItem(
        @SerializedName("hasPhotoGallery") val hasPhotoGallery: Boolean,
        @SerializedName("hasVideo") val hasVideo: Boolean,
        @SerializedName("titleVisible") val titleVisible: Boolean,
        @SerializedName("fLike") val fLike: String,
        @SerializedName("publishDate") val publishDate: String,
        @SerializedName("shortText") val shortText: String,
        @SerializedName("fullPath") val fullPath: String,
        @SerializedName("category") val category: Category,
        @SerializedName("videoUrl") val videoUrl: String,
        @SerializedName("externalUrl") val externalUrl: String,
        @SerializedName("columnistName") val columnistName: String,
        @SerializedName("itemId") val itemId: String,
        @SerializedName("title") val title: String,
        @SerializedName("imageUrl") val imageUrl: String,
        @SerializedName("itemType") val itemType: String
    )
