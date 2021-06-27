package com.example.moviecatalogue.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.vo.Resource

class DetailTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel(){
    val tvShowId = MutableLiveData<String>()

    fun selectedTvShow(tvShowId: String){
        this.tvShowId.value = tvShowId
    }

    var tvShowEpisode: LiveData<Resource<TvShowWithEpisode>> = Transformations.switchMap(tvShowId){ mTvShowId ->
        movieCatalogueRepository.getTvShowWithEpisode(mTvShowId)
    }

    fun setFav(){
        val episodeResource = tvShowEpisode.value
        if (episodeResource != null){
            val tvShowWithEpisode = episodeResource.data

            if (tvShowWithEpisode != null){
                val tvShowEntity = tvShowWithEpisode.mTvShow
                val newState = !tvShowEntity.isFav
                movieCatalogueRepository.setFavTvShow(tvShowEntity, newState)
            }
        }
    }
}