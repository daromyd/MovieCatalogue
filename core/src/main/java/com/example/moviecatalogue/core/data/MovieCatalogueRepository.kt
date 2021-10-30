package com.example.moviecatalogue.core.data

import com.example.moviecatalogue.core.data.source.local.LocalDataSource
import com.example.moviecatalogue.core.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.example.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.core.data.source.remote.response.TvShowResponse
import com.example.moviecatalogue.core.domain.model.Episode
import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.core.domain.repository.IMovieCatalogueRepository
import com.example.moviecatalogue.core.utils.AppExecutors
import com.example.moviecatalogue.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieCatalogueRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieCatalogueRepository {

        override fun getAllMovie(): Flow<Resource<List<Movie>>> =
                object : com.example.moviecatalogue.core.data.NetworkBoundResource<List<Movie>, List<MovieResponse>>(){
                        override fun loadFromDB(): Flow<List<Movie>> {
                                return localDataSource.getAllMovie().map { DataMapper.mapMovieEntitiesToDomain(it) }
                        }

                        override fun shouldFetch(data: List<Movie>?): Boolean =
                                data == null || data.isEmpty()

                        override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                                remoteDataSource.getAllMovie()

                        override suspend fun saveCallResult(data: List<MovieResponse>) {
                                val movieList = DataMapper.mapMovieResponseToEntities(data)
                                localDataSource.insertMovie(movieList)
                        }

                }.asFlow()

        override fun getFavoriteMovie(): Flow<List<Movie>> {
                return localDataSource.getFavoriteMovie().map { DataMapper.mapMovieEntitiesToDomain(it) }
        }

        override fun setFavoriteMovie(movie: Movie, state: Boolean) {
                val movieEntity = DataMapper.mapMovieDomainToEntity(movie)
                appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
        }

        override fun getAllTvShow(): Flow<Resource<List<Movie>>> =
                object : com.example.moviecatalogue.core.data.NetworkBoundResource<List<Movie>, List<TvShowResponse>>(){
                        override fun loadFromDB(): Flow<List<Movie>> {
                                return localDataSource.getAllTvShow().map { DataMapper.mapTvShowEntitiesToDomain(it) }
                        }

                        override fun shouldFetch(data: List<Movie>?): Boolean =
                                data == null || data.isEmpty()

                        override suspend fun createCall(): Flow<ApiResponse<List<TvShowResponse>>> =
                                remoteDataSource.getAllTvShow()

                        override suspend fun saveCallResult(data: List<TvShowResponse>) {
                                val tvShowList = DataMapper.mapTvShowResponseToEntities(data)
                                localDataSource.insertTvShow(tvShowList)
                        }

                }.asFlow()

        override fun getFavoriteTvShow(): Flow<List<Movie>> {
                return localDataSource.getFavoriteTvShow().map { DataMapper.mapTvShowEntitiesToDomain(it) }
        }

        override fun setFavoriteTvShow(tvShow: Movie, state: Boolean) {
                val tvShowEntity = DataMapper.mapTvShowDomainToEntity(tvShow)
                appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShowEntity, state) }
        }

        override suspend fun getEpisode(id: Int): List<Episode> {
                val remoteData = remoteDataSource.getEpisode(id)
                return DataMapper.mapEpisodeResponseToDomain(remoteData)
        }
}