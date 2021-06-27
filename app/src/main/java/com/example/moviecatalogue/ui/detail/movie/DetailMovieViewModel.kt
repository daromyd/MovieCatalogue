package com.example.moviecatalogue.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    lateinit var movieId : String

    fun setSelectedMovie(movieId: String){
        this.movieId = movieId
    }

    fun getMovie(): LiveData<MovieEntity> = movieCatalogueRepository.getDetailMovie(movieId)

    fun setFavMovie(movie: MovieEntity){
        val newState = !(movie.isFav)
        movieCatalogueRepository.setFavMovie(movie, newState)
    }
}
