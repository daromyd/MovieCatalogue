package com.example.moviecatalogue.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.TvShowWithEpisode
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer : Observer<Resource<TvShowWithEpisode>>

    @Before
    fun setUp(){
        viewModel = DetailTvShowViewModel(movieCatalogueRepository)
        viewModel.selectedTvShow(tvShowId)
    }

//    @Test
//    fun getTvShowWithEpisode(){
//        val dummyTvShowWithEpisode = Resource.success(DataDummy.generateDummyTvShowWithEpisode(dummyTvShow, true))
//        val tvShow = MutableLiveData<Resource<TvShowWithEpisode>>()
//        tvShow.value = dummyTvShowWithEpisode
//
//        `when`(movieCatalogueRepository.getTvShowWithEpisode(tvShowId)).thenReturn(tvShow)
//
//        viewModel.tvShowEpisode.observeForever(observer)
//
//        verify(observer).onChanged(dummyTvShowWithEpisode)
//    }

    @Test
    fun `selectedTvShow should be success`(){
        val expected = MutableLiveData<Resource<TvShowWithEpisode>>()
        expected.value = Resource.success(DataDummy.generateDummyTvShowWithEpisode(dummyTvShow, true))

        `when`(movieCatalogueRepository.getTvShowWithEpisode(tvShowId)).thenReturn(expected)

        viewModel.tvShowEpisode.observeForever(observer)

        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.tvShowEpisode.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFav should be success trigger tvShowEpisode observer`() {
        val expected = MutableLiveData<Resource<TvShowWithEpisode>>()
        expected.value = Resource.success(DataDummy.generateDummyTvShowWithEpisode(dummyTvShow, true))

        `when`(movieCatalogueRepository.getTvShowWithEpisode(tvShowId)).thenReturn(expected)

        viewModel.setFav()
        viewModel.tvShowEpisode.observeForever(observer)

        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.tvShowEpisode.value

        assertEquals(expectedValue, actualValue)
    }
}