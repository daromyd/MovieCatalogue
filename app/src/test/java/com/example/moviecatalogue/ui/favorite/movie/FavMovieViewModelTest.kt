package com.example.moviecatalogue.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.moviecatalogue.data.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {
    private lateinit var viewModel: FavMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Before
    fun setUp(){
        viewModel = FavMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun `getFavMovie should be success`() {
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = PagedTestDataSources.snapshot(DataDummy.generateDummyMovies())

        `when`(movieCatalogueRepository.getFavMovies()).thenReturn(expected)

        viewModel.getFavMovie().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavMovie().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavMovie should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(movieCatalogueRepository.getFavMovies()).thenReturn(expected)

        viewModel.getFavMovie().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getFavMovie().value?.size
        Assert.assertTrue("size of data should be 0, actual is $actualValueDataSize", actualValueDataSize == 0)
    }

    class PagedTestDataSources private constructor(private val items: List<MovieEntity>) : PositionalDataSource<MovieEntity>() {
        companion object {
            fun snapshot(items: List<MovieEntity> = listOf()): PagedList<MovieEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MovieEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MovieEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}