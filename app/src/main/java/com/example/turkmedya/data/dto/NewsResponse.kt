package com.example.turkmedya.data.dto
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("errorCode") val errorCode: Int,
    @SerializedName("errorMessage") val errorMessage: String?,
    @SerializedName("data") val data: List<Section>
)
