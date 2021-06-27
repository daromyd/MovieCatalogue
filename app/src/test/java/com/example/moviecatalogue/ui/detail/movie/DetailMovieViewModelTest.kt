package com.example.moviecatalogue.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun `setSelectedMovie should be success`(){
        val expected = MutableLiveData<MovieEntity>()
        expected.value = DataDummy.generateDummyMovies()[0]

        `when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(expected)

        viewModel.getMovie().observeForever(observer)

        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getMovie().value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFav should be success trigger getMovie observer`() {
        val expected = MutableLiveData<MovieEntity>()
        expected.value = DataDummy.generateDummyMovies()[0]

        `when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(expected)

        viewModel.setFavMovie(dummyMovie)
        viewModel.getMovie().observeForever(observer)

        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getMovie().value

        assertEquals(expectedValue, actualValue)
    }
}