package com.example.tmdbapp.presentation.di.playingmovie

import com.example.tmdbapp.domain.usecase.GetPlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.GetPopularMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePopularMoviesUseCase
import com.example.tmdbapp.presentation.playingmovies.PlayingMovieViewModelFactory
import com.example.tmdbapp.presentation.popularmovies.PopularMovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PlayingMovieModule {

    @PlayinMovieScope
    @Provides
    fun providePlayingMovieViewModelFactory(
        getPlayingMoviesUseCase: GetPlayingMoviesUseCase,
        updatePlayingMoviesUseCase: UpdatePlayingMoviesUseCase
    ): PlayingMovieViewModelFactory {
        return PlayingMovieViewModelFactory(
            getPlayingMoviesUseCase,
            updatePlayingMoviesUseCase
        )
    }

}