package com.example.tmdbapp.presentation.popularmovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbapp.domain.usecase.GetPopularMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePopularMoviesUseCase

class PopularMovieViewModelFactory (
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val updatePopularMoviesUseCase: UpdatePopularMoviesUseCase):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PopularMoviesViewModel(getPopularMoviesUseCase,updatePopularMoviesUseCase) as T
    }

}