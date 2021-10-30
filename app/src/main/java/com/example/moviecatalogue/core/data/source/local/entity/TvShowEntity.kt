package com.example.moviecatalogue.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tvShow")
data class TvShowEntity(
        @PrimaryKey
        @NotNull
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "releaseDate")
        var release: String,

        @ColumnInfo(name = "rating")
        var rating: Double,

        @ColumnInfo(name = "overview")
        var overview: String,

        @ColumnInfo(name = "imgUrl")
        var imageUrl: String,

        @ColumnInfo(name = "isFav")
        var isFav: Boolean = false
)
