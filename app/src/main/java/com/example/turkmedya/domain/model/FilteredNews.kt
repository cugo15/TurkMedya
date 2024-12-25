package com.example.turkmedya.domain.model

import android.os.Parcelable
import com.example.turkmedya.data.dto.Category
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
//Android özelinde daha performanslı bir kütüphane olduğu için parcelable tercih ediyorum
data class FilteredNews(val title: String,
                        val imageUrl: String,
                        val shortText: String,
                        val publishDate: String,
                        val category: @RawValue Category) : Parcelable

