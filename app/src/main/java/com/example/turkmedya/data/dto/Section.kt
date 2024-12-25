package com.example.turkmedya.data.dto

import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("sectionType") val sectionType: String,
    @SerializedName("repeatType") val repeatType: String,
    @SerializedName("itemCountInRow") val itemCountInRow: Int,
    @SerializedName("lazyLoadingEnabled") val lazyLoadingEnabled: Boolean,
    @SerializedName("titleVisible") val titleVisible: Boolean,
    @SerializedName("title") val title: String?,
    @SerializedName("titleColor") val titleColor: String?,
    @SerializedName("titleBgColor") val titleBgColor: String?,
    @SerializedName("sectionBgColor") val sectionBgColor: String?,
    @SerializedName("itemList") val itemList: List<NewsItem>
)
