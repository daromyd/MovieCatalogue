package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var year: Int,
    var rating: Float,
    var duration: Int,
    var genre: String,
    var sinopsis: String,
    var poster: String
) : Parcelable
