package com.example.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class MovieViewModel(movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel() {

    val movie = movieCatalogueUseCase.getAllMovie().asLiveData()
}