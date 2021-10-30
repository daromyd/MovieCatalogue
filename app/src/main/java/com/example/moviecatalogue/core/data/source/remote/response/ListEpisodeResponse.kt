package com.example.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListEpisodeResponse(

    @field:SerializedName("_id")
    val id: String,

    @field:SerializedName("air_date")
    val date: String,

    @field:SerializedName("episodes")
    val episode: List<EpisodeResponse>
)
