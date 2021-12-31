package com.example.tmdbapp.data.repository.playingmovie.datasource

import com.example.tmdbapp.data.model.playing.PlayingMovie

interface PlayingMovieLocalDataSource {

    suspend fun getPlayingMoviesFromDB():List<PlayingMovie>
    suspend fun savePlayingMoviesFromDB(playingMovies:List<PlayingMovie>)
    suspend fun clearAll()
}