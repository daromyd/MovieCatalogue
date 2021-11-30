package com.example.moviecatalogue.core.domain.repository

import com.example.moviecatalogue.core.data.Resource
import com.example.moviecatalogue.core.domain.model.Episode
import com.example.moviecatalogue.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieCatalogueRepository {

    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

    fun getAllTvShow(): Flow<Resource<List<Movie>>>

    fun getFavoriteTvShow(): Flow<List<Movie>>

    fun setFavoriteTvShow(tvShow: Movie, state: Boolean)

    fun getEpisode(id: Int): Flow<List<Episode>>
}