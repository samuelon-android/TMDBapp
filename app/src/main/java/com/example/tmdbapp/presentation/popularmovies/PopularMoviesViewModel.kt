package com.example.tmdbapp.presentation.popularmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbapp.domain.usecase.GetPlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.GetPopularMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePopularMoviesUseCase

class PopularMoviesViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val updatePopularMoviesUseCase: UpdatePopularMoviesUseCase):ViewModel() {

    fun get_popularMovies() = liveData{
        val popularMovieList = getPopularMoviesUseCase.execute()
        emit(popularMovieList)
    }

    fun update_popularMovies() = liveData {
        val popularMovieList = updatePopularMoviesUseCase.execute()
        emit(popularMovieList)
    }

}