package com.example.tmdbapp.presentation.di.core

import com.example.tmdbapp.domain.repository.PlayingMovieRepository
import com.example.tmdbapp.domain.repository.PopularMovieRepository
import com.example.tmdbapp.domain.usecase.GetPlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.GetPopularMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePlayingMoviesUseCase
import com.example.tmdbapp.domain.usecase.UpdatePopularMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {


    @Provides
    fun provideGetPopularMovieUseCase(popularMovieRepository: PopularMovieRepository):GetPopularMoviesUseCase{
        return GetPopularMoviesUseCase(popularMovieRepository)
    }

    @Provides
    fun provideUpdatePopularMovieUseCase(popularMovieRepository: PopularMovieRepository): UpdatePopularMoviesUseCase {
        return UpdatePopularMoviesUseCase(popularMovieRepository)
    }


    @Provides
    fun provideGetPlayingMovieUseCase(playingMovieRepository: PlayingMovieRepository): GetPlayingMoviesUseCase {
        return GetPlayingMoviesUseCase(playingMovieRepository)
    }

    @Provides
    fun provideUpdatePlayingMovieUseCase(playingMovieRepository: PlayingMovieRepository): UpdatePlayingMoviesUseCase {
        return UpdatePlayingMoviesUseCase(playingMovieRepository)
    }

}