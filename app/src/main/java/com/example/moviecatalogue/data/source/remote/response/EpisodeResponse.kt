package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeResponse(
    var episodeId: String,
    var tvShowId: String,
    var title: String,
    var duration: Int
) : Parcelable
