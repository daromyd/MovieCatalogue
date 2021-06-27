package com.example.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.MovieEntity

class FavMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getFavMovie(): LiveData<PagedList<MovieEntity>>{
        return movieCatalogueRepository.getFavMovies()
    }

    fun setFav(movieEntity: MovieEntity){
        val newState = !movieEntity.isFav
        movieCatalogueRepository.setFavMovie(movieEntity, newState)
    }
}