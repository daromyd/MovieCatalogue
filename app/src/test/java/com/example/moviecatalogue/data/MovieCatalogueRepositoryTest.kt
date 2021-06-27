package com.example.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.entity.EpisodeEntity
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.LiveDataTestUtil
import com.example.moviecatalogue.utils.PagedListUtil
import com.example.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieCatalogueRepository =  FakeMovieCatalogueRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].movieId

    private val tvShowResponse = DataDummy.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponse[0].tvShowId
    private val title = tvShowResponse[0].title
    private val eps = tvShowResponse[0].eps

    private val episodeResponse = DataDummy.generateRemoteDummyEpisodes(tvShowId, title, eps)

    @Test
    fun getAllMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie(){
        val dummyMovies = MutableLiveData<MovieEntity>()
        dummyMovies.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyMovies)

        val resultMovie = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))

        verify(local).getDetailMovie(movieId)

        assertNotNull(resultMovie)
        assertNotNull(resultMovie.title)
        assertEquals(movieResponse[0].title, resultMovie.title)
    }

    @Test
    fun getEpisodesByTvShow(){
        val dummyEpisodes = MutableLiveData<List<EpisodeEntity>>()
        dummyEpisodes.value = DataDummy.generateDummyEpisodes(tvShowId, title, eps)
        `when`(local.getAllEpisodesByTvShow(tvShowId)).thenReturn(dummyEpisodes)

        val episodeEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getEpisodesByTvShow(tvShowId))

        verify(local).getAllEpisodesByTvShow(tvShowId)
        assertNotNull(episodeEntities.data)
        assertEquals(episodeResponse.size.toLong(), episodeEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowWithEpisode(){
        val dummyEntity = MutableLiveData<TvShowWithEpisode>()
        dummyEntity.value = DataDummy.generateDummyTvShowWithEpisode(DataDummy.generateDummyTvShows()[0], false)
        `when`(local.getTvShowWithEpisode(tvShowId)).thenReturn(dummyEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShowWithEpisode(tvShowId))
        verify(local).getTvShowWithEpisode(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertNotNull(tvShowEntities.data?.mTvShow?.title)
        assertEquals(tvShowResponse[0].title, tvShowEntities.data?.mTvShow?.title)
    }

    @Test
    fun getFavMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavTvShow(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun setFavMovie(){
        val movie = DataDummy.generateDummyMovies()[0]

        movieCatalogueRepository.setFavMovie(movie, true)

        verify(local, times(1)).setFavMovie(movie, true)
    }

    @Test
    fun setFavTvShow(){
        val tvShow = DataDummy.generateDummyTvShows()[0]

        movieCatalogueRepository.setFavTvShow(tvShow, true)

        verify(local, times(1)).setFavTvShow(tvShow, true)
    }
}