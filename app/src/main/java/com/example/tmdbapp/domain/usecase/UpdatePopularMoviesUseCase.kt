package com.example.tmdbapp.domain.usecase

import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.domain.repository.PopularMovieRepository

class UpdatePopularMoviesUseCase(private val popularMovieRepository: PopularMovieRepository) {

    suspend fun execute() : List<PopularMovie>? = popularMovieRepository.updatePopularMovies()

}