package com.example.tmdbapp.presentation.di.popularmovie

import com.example.tmdbapp.presentation.popularmovies.PopularMoviesActivity
import dagger.Subcomponent

@PopularMovieScope
@Subcomponent(modules = [PopularMovieModule::class])
interface PopularMovieSubComponent {
    fun inject(popularMoviesActivity: PopularMoviesActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():PopularMovieSubComponent
    }

}