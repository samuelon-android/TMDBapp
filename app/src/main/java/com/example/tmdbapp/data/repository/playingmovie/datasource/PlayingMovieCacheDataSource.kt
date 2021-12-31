package com.example.tmdbapp.data.repository.playingmovie.datasource

import com.example.tmdbapp.data.model.playing.PlayingMovie

interface PlayingMovieCacheDataSource {

    suspend fun getPlayingMoviesFromCache():List<PlayingMovie>
    suspend fun savePlayingMoviesFromCache(playingMovies:List<PlayingMovie>)

}