package com.example.moviecatalogue.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TvShowWithEpisode(
    @Embedded
    var mTvShow: TvShowEntity,

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    var mEpisode: List<EpisodeEntity>
)
