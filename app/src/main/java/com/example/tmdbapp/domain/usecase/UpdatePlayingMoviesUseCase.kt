package com.example.tmdbapp.domain.usecase

import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.domain.repository.PlayingMovieRepository

class UpdatePlayingMoviesUseCase(private val playingMovieRepository: PlayingMovieRepository) {

    suspend fun execute() : List<PlayingMovie>? = playingMovieRepository.updatePlayingMovies()

}