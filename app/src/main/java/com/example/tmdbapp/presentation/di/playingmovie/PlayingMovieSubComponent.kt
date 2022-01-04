package com.example.tmdbapp.presentation.di.playingmovie

import com.example.tmdbapp.presentation.playingmovies.PlayingMoviesActivity
import com.example.tmdbapp.presentation.popularmovies.PopularMoviesActivity
import dagger.Subcomponent

@PlayinMovieScope
@Subcomponent(modules = [PlayingMovieModule::class])
interface PlayingMovieSubComponent {
    fun inject(playingMoviesActivity: PlayingMoviesActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():PlayingMovieSubComponent
    }

}