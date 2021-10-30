package com.example.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTvShowResponse(

    @field:SerializedName("_id")
    val id: String,

    @field:SerializedName("air_date")
    val airDate: String,

    @field:SerializedName("results")
    val result: List<TvShowResponse>
)
