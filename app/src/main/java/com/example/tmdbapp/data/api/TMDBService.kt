package com.example.tmdbapp.data.api

import com.example.tmdbapp.data.model.playing.PlayingMovieList
import com.example.tmdbapp.data.model.popular.PopularMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<PopularMovieList>

    @GET("movie/now_playing")
    suspend fun getPlayingMovies(@Query("api_key")apiKey:String):Response<PlayingMovieList>

}