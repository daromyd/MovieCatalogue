package com.example.moviecatalogue.core.utils

import com.example.moviecatalogue.core.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.core.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.core.data.source.remote.response.EpisodeResponse
import com.example.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.core.data.source.remote.response.TvShowResponse
import com.example.moviecatalogue.core.domain.model.Episode
import com.example.moviecatalogue.core.domain.model.Movie

object DataMapper {

    fun mapMovieResponseToEntities(input: List<MovieResponse>): List<MovieEntity>{
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                release = it.release,
                rating = it.rate,
                overview = it.overview,
                imageUrl = it.imageUrl,
                isFav = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapMovieEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                release = it.release,
                rate = it.rating,
                overview = it.overview,
                imageUrl = it.imageUrl,
                isFav = it.isFav
            )
        }

    fun mapMovieDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        title = input.title,
        release = input.release,
        rating = input.rate,
        overview = input.overview,
        imageUrl = input.imageUrl,
        isFav = input.isFav
    )

    fun mapTvShowResponseToEntities(input: List<TvShowResponse>): List<TvShowEntity>{
        val tvShowList = ArrayList<TvShowEntity>()
        input.map {
            val tvShow = TvShowEntity(
                id = it.id,
                name = it.title,
                release = it.release,
                rating = it.rate,
                overview = it.overview,
                imageUrl = it.imageUrl,
                isFav = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapTvShowEntitiesToDomain(input: List<TvShowEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.name,
                release = it.release,
                rate = it.rating,
                overview = it.overview,
                imageUrl = it.imageUrl,
                isFav = it.isFav
            )
        }

    fun mapTvShowDomainToEntity(input: Movie) = TvShowEntity(
        id = input.id,
        name = input.title,
        release = input.release,
        rating = input.rate,
        overview = input.overview,
        imageUrl = input.imageUrl,
        isFav = input.isFav
    )

    fun mapEpisodeResponseToDomain(input: List<EpisodeResponse>): List<Episode>{
        val episodeList = ArrayList<Episode>()
        input.map {
            val episode = Episode(
                id = it.id,
                title = it.title,
                episodeNumber = it.episodeNumber,
                overview = it.overview,
                imageUrl = it.imageUrl
            )
            episodeList.add(episode)
        }
        return episodeList
    }
}