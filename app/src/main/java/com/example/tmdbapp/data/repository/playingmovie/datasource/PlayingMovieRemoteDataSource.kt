package com.example.tmdbapp.data.repository.playingmovie.datasource

import com.example.tmdbapp.data.model.playing.PlayingMovieList
import com.example.tmdbapp.data.model.popular.PopularMovieList
import retrofit2.Response

interface PlayingMovieRemoteDataSource {

    suspend fun getPlayingMovies(): Response<PlayingMovieList>

}