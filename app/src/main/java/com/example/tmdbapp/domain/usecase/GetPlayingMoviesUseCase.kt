package com.example.tmdbapp.domain.usecase

import com.example.tmdbapp.data.model.playing.PlayingMovie
import com.example.tmdbapp.domain.repository.PlayingMovieRepository

class GetPlayingMoviesUseCase(private val playingMovieRepository: PlayingMovieRepository) {

    suspend fun execute(): List<PlayingMovie>? = playingMovieRepository.getPlayingMovies()

}