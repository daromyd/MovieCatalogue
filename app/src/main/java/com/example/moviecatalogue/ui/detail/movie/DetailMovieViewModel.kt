package com.example.moviecatalogue.ui.detail.movie

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class DetailMovieViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) = movieCatalogueUseCase.setFavoriteMovie(movie, newStatus)
}
