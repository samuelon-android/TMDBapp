package com.example.tmdbapp.presentation.di.core

import com.example.tmdbapp.presentation.di.playingmovie.PlayingMovieSubComponent
import com.example.tmdbapp.presentation.di.popularmovie.PopularMovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun popularMovieSubcomponent():PopularMovieSubComponent.Factory
    fun playingMovieSubcomponent():PlayingMovieSubComponent.Factory

}