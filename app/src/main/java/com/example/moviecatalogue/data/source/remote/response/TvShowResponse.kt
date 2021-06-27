package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse(
    var tvShowId: String,
    var title: String,
    var year: Int,
    var rating: Float,
    var eps: Int,
    var genre: String,
    var sinopsis: String,
    var poster: String
):Parcelable
