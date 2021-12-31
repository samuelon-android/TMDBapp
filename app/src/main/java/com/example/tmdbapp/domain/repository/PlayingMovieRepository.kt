package com.example.tmdbapp.domain.repository

import com.example.tmdbapp.data.model.playing.PlayingMovie

interface PlayingMovieRepository {

    suspend fun getPlayingMovies(): List<PlayingMovie>?
    suspend fun updatePlayingMovies(): List<PlayingMovie>?

}