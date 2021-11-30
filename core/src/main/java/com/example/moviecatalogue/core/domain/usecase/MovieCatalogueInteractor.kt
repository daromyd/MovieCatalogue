package com.example.moviecatalogue.core.domain.usecase

import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.core.domain.repository.IMovieCatalogueRepository

class MovieCatalogueInteractor(private val movieCatalogueRepository: IMovieCatalogueRepository): MovieCatalogueUseCase {
    override fun getAllMovie() = movieCatalogueRepository.getAllMovie()

    override fun getFavoriteMovie() = movieCatalogueRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieCatalogueRepository.setFavoriteMovie(movie, state)

    override fun getAllTvShow() = movieCatalogueRepository.getAllTvShow()

    override fun getFavoriteTvShow()= movieCatalogueRepository.getFavoriteTvShow()

    override fun setFavoriteTvShow(tvShow: Movie, state: Boolean) = movieCatalogueRepository.setFavoriteTvShow(tvShow, state)

    override fun getEpisode(id: Int) = movieCatalogueRepository.getEpisode(id)
}