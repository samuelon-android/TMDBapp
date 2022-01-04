package com.example.tmdbapp.presentation.di.popularmovie

import com.example.tmdbapp.domain.usecase.GetPopularMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePopularMoviesUseCase
import com.example.tmdbapp.presentation.popularmovies.PopularMovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PopularMovieModule {

    @PopularMovieScope
    @Provides
    fun providePopularMovieViewModelFactory(
        getPopularMoviesUseCase: GetPopularMoviesUseCase,
        updatePopularMoviesUseCase: UpdatePopularMoviesUseCase):PopularMovieViewModelFactory{
        return PopularMovieViewModelFactory(
            getPopularMoviesUseCase,
            updatePopularMoviesUseCase
        )
    }

}