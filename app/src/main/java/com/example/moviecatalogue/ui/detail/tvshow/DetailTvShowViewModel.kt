package com.example.moviecatalogue.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase

class DetailTvShowViewModel(private val movieCatalogueUseCase: MovieCatalogueUseCase) : ViewModel(){
    fun setFavoriteTvShow(tvShow: Movie, newStatus: Boolean) = movieCatalogueUseCase.setFavoriteTvShow(tvShow, newStatus)

    suspend fun getEpisode(id: Int) = movieCatalogueUseCase.getEpisode(id)
}