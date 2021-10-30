package com.example.moviecatalogue.core.data.source.local

import com.example.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.core.data.source.local.room.MovieCatalogueDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieCatalogueDao : MovieCatalogueDao){

    fun getAllMovie(): Flow<List<MovieEntity>> = movieCatalogueDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieCatalogueDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieCatalogueDao.insertMovie(movieList)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean){
        movie.isFav = newState
        movieCatalogueDao.updateFavoriteMovie(movie)
    }

    fun getAllTvShow(): Flow<List<TvShowEntity>> = movieCatalogueDao.getAllTvShow()

    fun getFavoriteTvShow(): Flow<List<TvShowEntity>> = movieCatalogueDao.getFavoriteTvShow()

    suspend fun insertTvShow(tvShowList: List<TvShowEntity>) = movieCatalogueDao.insertTvShow(tvShowList)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean){
        tvShow.isFav = newState
        movieCatalogueDao.updateFavoriteTvShow(tvShow)
    }

}