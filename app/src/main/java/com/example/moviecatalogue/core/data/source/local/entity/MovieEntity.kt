package com.example.moviecatalogue.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "releaseDate")
    var release: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "genre")
    var overview: String,

    @ColumnInfo(name = "imgUrl")
    var imageUrl: String,

    @ColumnInfo(name = "isFav")
    var isFav: Boolean = false

)
