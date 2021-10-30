package com.example.moviecatalogue.favorite

import com.example.moviecatalogue.favorite.movie.FavMovieViewModel
import com.example.moviecatalogue.favorite.tvshow.FavTvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavMovieViewModel(get()) }
    viewModel { FavTvShowViewModel(get()) }
}