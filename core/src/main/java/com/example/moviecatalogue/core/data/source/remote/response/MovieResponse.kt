package com.example.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("original_title")
    val title: String,

    @field:SerializedName("release_date")
    val release: String,

    @field:SerializedName("vote_average")
    val rate: Double,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val imageUrl: String
)