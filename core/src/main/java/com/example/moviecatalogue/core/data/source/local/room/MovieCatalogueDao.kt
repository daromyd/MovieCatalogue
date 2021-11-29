package com.example.moviecatalogue.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<com.example.moviecatalogue.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM movie where isFav = 1")
    fun getFavoriteMovie(): Flow<List<com.example.moviecatalogue.core.data.source.local.entity.MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<com.example.moviecatalogue.core.data.source.local.entity.MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: com.example.moviecatalogue.core.data.source.local.entity.MovieEntity)

    @Query("SELECT * FROM tvShow")
    fun getAllTvShow(): Flow<List<com.example.moviecatalogue.core.data.source.local.entity.TvShowEntity>>

    @Query("SELECT * FROM tvShow WHERE isFav = 1")
    fun getFavoriteTvShow(): Flow<List<com.example.moviecatalogue.core.data.source.local.entity.TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvShow: List<com.example.moviecatalogue.core.data.source.local.entity.TvShowEntity>)

    @Update
    fun updateFavoriteTvShow(tvShow: com.example.moviecatalogue.core.data.source.local.entity.TvShowEntity)

}