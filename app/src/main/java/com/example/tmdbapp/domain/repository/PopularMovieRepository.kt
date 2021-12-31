package com.example.tmdbapp.domain.repository

import com.example.tmdbapp.data.model.popular.PopularMovie

interface PopularMovieRepository {

    suspend fun getPopularMovies() : List<PopularMovie>?
    suspend fun updatePopularMovies() : List<PopularMovie>?

}