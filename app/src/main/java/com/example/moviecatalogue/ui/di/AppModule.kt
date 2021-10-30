package com.example.moviecatalogue.ui.di

import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueInteractor
import com.example.moviecatalogue.core.domain.usecase.MovieCatalogueUseCase
import com.example.moviecatalogue.ui.detail.movie.DetailMovieViewModel
import com.example.moviecatalogue.ui.detail.tvshow.DetailTvShowViewModel
import com.example.moviecatalogue.ui.favorite.movie.FavMovieViewModel
import com.example.moviecatalogue.ui.favorite.tvshow.FavTvShowViewModel
import com.example.moviecatalogue.ui.movies.MovieViewModel
import com.example.moviecatalogue.ui.tvshow.TvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieCatalogueUseCase> { MovieCatalogueInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
    viewModel { DetailTvShowViewModel(get()) }
    viewModel { FavMovieViewModel(get()) }
    viewModel { FavTvShowViewModel(get()) }
}