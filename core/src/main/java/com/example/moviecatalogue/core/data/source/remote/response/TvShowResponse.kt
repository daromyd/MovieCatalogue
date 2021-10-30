package com.example.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TvShowResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val title: String,

    @field:SerializedName("first_air_date")
    val release: String,

    @field:SerializedName("vote_average")
    val rate: Double,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val imageUrl: String
)
