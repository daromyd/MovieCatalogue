package com.example.moviecatalogue.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import org.jetbrains.annotations.NotNull

@Entity(tableName = "episodeentities",
        primaryKeys = ["episodeId", "tvShowId"],
        foreignKeys = [ForeignKey(entity = TvShowEntity::class,
                parentColumns = ["tvShowId"],
                childColumns = ["tvShowId"])],
        indices = [Index(value = ["episodeId"]),
                Index(value = ["tvShowId"])])
data class EpisodeEntity(
        @NotNull
        @ColumnInfo(name = "episodeId")
        var episodeId: String,

        @NotNull
        @ColumnInfo(name = "tvShowId")
        var tvShowId: String,

        @NotNull
        @ColumnInfo(name = "title")
        var title: String,

        @NotNull
        @ColumnInfo(name = "duration")
        var duration: Int
)
