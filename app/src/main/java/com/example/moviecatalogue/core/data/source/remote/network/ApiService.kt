package com.example.moviecatalogue.core.data.source.remote.network

import com.example.moviecatalogue.core.data.source.remote.response.ListEpisodeResponse
import com.example.moviecatalogue.core.data.source.remote.response.ListMovieResponse
import com.example.moviecatalogue.core.data.source.remote.response.ListTvShowResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovie(@Query("api_key") apiKey: String): ListMovieResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(@Query("api_key") apiKey: String): ListTvShowResponse

    @GET("tv/{id}/season/1")
    suspend fun getEpisode(@Path("id") id: Int, @Query("api_key") apiKey: String): ListEpisodeResponse
}