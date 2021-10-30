package com.example.moviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val release: String,
    val rate: Double,
    val overview: String,
    val imageUrl: String,
    val isFav: Boolean
): Parcelable
