package com.example.tmdbapp.data.repository.playingmovie.datasourceImpl

import com.example.tmdbapp.data.api.TMDBService
import com.example.tmdbapp.data.model.playing.PlayingMovieList
import com.example.tmdbapp.data.repository.playingmovie.datasource.PlayingMovieRemoteDataSource
import retrofit2.Response

class PlayingMovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                       private val apiKey:String): PlayingMovieRemoteDataSource {

    override suspend fun getPlayingMovies(): Response<PlayingMovieList> = tmdbService.getPlayingMovies(apiKey)
}