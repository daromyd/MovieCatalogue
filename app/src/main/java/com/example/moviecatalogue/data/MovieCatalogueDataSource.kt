package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.EpisodeEntity
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailMovie(movieId: String): LiveData<MovieEntity>

    fun getEpisodesByTvShow(tvShowId: String): LiveData<Resource<List<EpisodeEntity>>>

    fun getTvShowWithEpisode(tvShowId: String): LiveData<Resource<TvShowWithEpisode>>

    fun setFavMovie(movie: MovieEntity, state: Boolean)

    fun setFavTvShow(tvShow: TvShowEntity, state: Boolean)
}