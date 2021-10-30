package com.example.moviecatalogue.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Episode(
    val id: Int,
    val title: String,
    val episodeNumber: Int,
    val overview: String,
    val imageUrl: String? = ""
): Parcelable
