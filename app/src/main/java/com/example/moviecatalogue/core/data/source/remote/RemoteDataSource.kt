package com.example.moviecatalogue.core.data.source.remote

import android.util.Log
import com.example.moviecatalogue.core.data.source.remote.network.ApiResponse
import com.example.moviecatalogue.core.data.source.remote.network.ApiService
import com.example.moviecatalogue.core.data.source.remote.response.EpisodeResponse
import com.example.moviecatalogue.core.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.core.data.source.remote.response.TvShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val apiService: ApiService) {
    companion object{
        const val key = "65abe407e04b79e3db831db88e99c56a"
    }


    suspend fun getAllMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getTrendingMovie(key)
                val dataArray = response.result
                if (dataArray.isEmpty()){
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response.result))
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllTvShow(): Flow<ApiResponse<List<TvShowResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getTrendingTvShow(key)
                val dataArray = response.result
                if (dataArray.isEmpty()){
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response.result))
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getEpisode(id:Int) : List<EpisodeResponse>{
        return apiService.getEpisode(id, key).episode
    }
}
