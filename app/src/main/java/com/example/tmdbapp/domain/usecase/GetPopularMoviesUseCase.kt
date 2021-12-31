package com.example.tmdbapp.domain.usecase

import com.example.tmdbapp.data.model.popular.PopularMovie
import com.example.tmdbapp.domain.repository.PopularMovieRepository

class GetPopularMoviesUseCase(private val popularMovieRepository: PopularMovieRepository) {

    suspend fun execute(): List<PopularMovie>? = popularMovieRepository.getPopularMovies()

}