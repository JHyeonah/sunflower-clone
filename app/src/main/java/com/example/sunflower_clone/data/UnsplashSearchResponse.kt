package com.example.sunflower_clone.data

import com.google.gson.annotations.SerializedName

data class UnsplashSearchResponse(
        @field:SerializedName("results") val result: List<String>,
        @field:SerializedName("total_pages") val totalPages: Int
)