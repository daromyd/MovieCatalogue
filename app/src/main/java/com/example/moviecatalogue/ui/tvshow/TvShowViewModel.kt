package com.example.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class TvShowViewModel(movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel(){

    val tvShow = movieCatalogueUseCase.getAllTvShow().asLiveData()
}