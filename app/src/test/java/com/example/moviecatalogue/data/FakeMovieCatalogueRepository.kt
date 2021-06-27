package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.entity.EpisodeEntity
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.data.source.remote.ApiResponse
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.data.source.remote.response.EpisodeResponse
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.vo.Resource
import java.util.*

class FakeMovieCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors) : MovieCatalogueDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data){
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.year,
                        response.rating,
                        response.duration,
                        response.genre,
                        response.sinopsis,
                        response.poster,
                        false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data){
                    val tvShow = TvShowEntity(
                        response.tvShowId,
                        response.title,
                        response.year,
                        response.rating,
                        response.eps,
                        response.genre,
                        response.sinopsis,
                        response.poster,
                        false
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieEntity> = localDataSource.getDetailMovie(movieId)

    override fun getEpisodesByTvShow(tvShowId: String): LiveData<Resource<List<EpisodeEntity>>> {
        return object : NetworkBoundResource<List<EpisodeEntity>, List<EpisodeResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<EpisodeEntity>> =
                localDataSource.getAllEpisodesByTvShow(tvShowId)

            override fun shouldFetch(data: List<EpisodeEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<EpisodeResponse>>> =
                remoteDataSource.getEpisodes(tvShowId)

            override fun saveCallResult(data: List<EpisodeResponse>) {
                val episodeList = ArrayList<EpisodeEntity>()
                for (response in data){
                    val episode = EpisodeEntity(
                        response.episodeId,
                        response.tvShowId,
                        response.title,
                        response.duration
                    )
                    episodeList.add(episode)
                }
                localDataSource.insertEpisodes(episodeList)
            }
        }.asLiveData()
    }

    override fun getTvShowWithEpisode(tvShowId: String): LiveData<Resource<TvShowWithEpisode>> {
        return object : NetworkBoundResource<TvShowWithEpisode, List<EpisodeResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<TvShowWithEpisode> =
                localDataSource.getTvShowWithEpisode(tvShowId)

            override fun shouldFetch(data: TvShowWithEpisode?): Boolean =
                data?.mEpisode == null || data.mEpisode.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<EpisodeResponse>>> =
                remoteDataSource.getEpisodes(tvShowId)

            override fun saveCallResult(data: List<EpisodeResponse>) {
                val episodeList = ArrayList<EpisodeEntity>()
                for (response in data){
                    val tvShow = EpisodeEntity(
                        response.episodeId,
                        response.tvShowId,
                        response.title,
                        response.duration
                    )
                    episodeList.add(tvShow)
                }
                localDataSource.insertEpisodes(episodeList)
            }
        }.asLiveData()
    }

    fun getFavMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    fun getFavTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavTvShows(), config).build()
    }

    override fun setFavMovie(movie: MovieEntity, state: Boolean) =
        localDataSource.setFavMovie(movie, state)

    override fun setFavTvShow(tvShow: TvShowEntity, state: Boolean) =
        localDataSource.setFavTvShow(tvShow, state)
}