package com.example.moviecatalogue.utils

import android.content.Context
import com.example.moviecatalogue.data.source.remote.response.EpisodeResponse
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JSONHelper(private val context : Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviesResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val movieId = movies.getString("movieId")
                val title = movies.getString("title")
                val year = movies.getInt("year")
                val rating = movies.getDouble("rating")
                val duration = movies.getInt("duration")
                val genre = movies.getString("genre")
                val sinopsis = movies.getString("sinopsis")
                val poster = movies.getString("poster")

                val movieResponse = MovieResponse(movieId, title, year, rating.toFloat(), duration, genre, sinopsis, poster)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowsResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val tvShowId = tvShow.getString("tvShowId")
                val title = tvShow.getString("title")
                val year = tvShow.getInt("year")
                val rating = tvShow.getDouble("rating")
                val eps = tvShow.getInt("eps")
                val genre = tvShow.getString("genre")
                val sinopsis = tvShow.getString("sinopsis")
                val poster = tvShow.getString("poster")

                val tvShowResponse = TvShowResponse(tvShowId, title, year, rating.toFloat(), eps, genre, sinopsis, poster)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadEpisode(tvShowId: String): List<EpisodeResponse> {
        val fileName = String.format("TvShow_%s.json", tvShowId)
        val list = ArrayList<EpisodeResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("episodes")
                for (i in 0 until listArray.length()) {
                    val episode = listArray.getJSONObject(i)

                    val episodeId = episode.getString("episodeId")
                    val title = episode.getString("title")
                    val duration = episode.getInt("duration")

                    val episodeResponse = EpisodeResponse(episodeId, tvShowId, title, duration)
                    list.add(episodeResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }


}