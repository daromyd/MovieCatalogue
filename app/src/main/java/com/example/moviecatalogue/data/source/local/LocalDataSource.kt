package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.entity.EpisodeEntity
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao : MovieCatalogueDao){

    companion object{
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getMovies()

    fun getDetailMovie(movieId: String): LiveData<MovieEntity> = mMovieCatalogueDao.getDetailMovie(movieId)

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getFavMovie()

    fun insertMovies(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)

    fun setFavMovie(movie: MovieEntity, newState: Boolean){
        movie.isFav = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getTvShows()

    fun getFavTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getFavTvShow()

    fun getTvShowWithEpisode(tvShowId: String): LiveData<TvShowWithEpisode> = mMovieCatalogueDao.getTvShowWithEpisodeById(tvShowId)

    fun getAllEpisodesByTvShow(tvShowId: String): LiveData<List<EpisodeEntity>> = mMovieCatalogueDao.getEpisodesByTvShowId(tvShowId)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieCatalogueDao.insertTvShows(tvShows)

    fun insertEpisodes(episodes: List<EpisodeEntity>) = mMovieCatalogueDao.insertEpisodes(episodes)

    fun setFavTvShow(tvShow: TvShowEntity, newState: Boolean){
        tvShow.isFav = newState
        mMovieCatalogueDao.updateTvShow(tvShow)
    }
}