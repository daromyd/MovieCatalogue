package com.example.moviecatalogue.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tvshowentities")
data class TvShowEntity(
        @PrimaryKey
        @NotNull
        @ColumnInfo(name = "tvShowId")
        var tvShowId: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "year")
        var year: Int,

        @ColumnInfo(name = "rating")
        var rating: Float,

        @ColumnInfo(name = "eps")
        var eps: Int,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "sinopsis")
        var sinopsis: String,

        @ColumnInfo(name = "poster")
        var poster: String,

        @ColumnInfo(name = "isFav")
        var isFav: Boolean = false
)
