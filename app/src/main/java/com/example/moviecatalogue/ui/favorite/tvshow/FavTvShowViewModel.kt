package com.example.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity

class FavTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getFavTvShow(): LiveData<PagedList<TvShowEntity>>{
        return movieCatalogueRepository.getFavTvShows()
    }

    fun setFav(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFav
        movieCatalogueRepository.setFavTvShow(tvShowEntity, newState)
    }
}