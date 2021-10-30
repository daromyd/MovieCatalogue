package com.example.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val title: String,

    @field:SerializedName("episode_number")
    val episodeNumber: Int,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("still_path")
    val imageUrl: String? = ""
)
