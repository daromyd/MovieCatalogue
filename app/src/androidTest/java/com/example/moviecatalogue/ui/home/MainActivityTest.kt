package com.example.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.moviecatalogue.R
import com.example.moviecatalogue.ui.splashscreen.SplashScreenActivity
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @Before
    fun setUp(){
        ActivityScenario.launch(SplashScreenActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(dummyMovie[0].year.toString())))
        onView(withId(R.id.tv_detail_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_duration)).check(matches(withText(dummyMovie[0].duration.toString()+" min")))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_detail_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rate)).check(matches(withText(dummyMovie[0].rating.toString())))
        onView(withId(R.id.tv_detail_sinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_sinopsis)).check(matches(withText(dummyMovie[0].sinopsis)))
        onView(withId(R.id.img_detail_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShow(){
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(dummyTvShow[0].year.toString())))
        onView(withId(R.id.tv_detail_episode)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_episode)).check(matches(withText(dummyTvShow[0].eps.toString()+" episode")))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_detail_rate)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rate)).check(matches(withText(dummyTvShow[0].rating.toString())))
        onView(withId(R.id.coor_tvShow)).perform(swipeUp())
        onView(withId(R.id.rv_eps)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavMovie(){
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_fav_movie)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.action_fav)).perform(click())
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_fav_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.btn_fav_movie)).perform(click())
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun loadFavTvShow(){
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_fav)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.action_fav)).perform(click())
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_fav_movies)).check(matches(isDisplayed()))
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_fav_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.btn_fav)).perform(click())
        onView(isRoot()).perform(pressBack())
    }
}