package com.example.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class FavMovieViewModel(movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    val favoriteMovie = movieCatalogueUseCase.getFavoriteMovie().asLiveData()
}