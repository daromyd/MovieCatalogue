package com.example.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class FavTvShowViewModel(movieCatalogueUseCase: MovieCatalogueUseCase): ViewModel() {
    val favoriteTvShow = movieCatalogueUseCase.getFavoriteTvShow().asLiveData()
}