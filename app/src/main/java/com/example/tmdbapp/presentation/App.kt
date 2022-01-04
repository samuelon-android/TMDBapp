package com.example.tmdbapp.presentation

import android.app.Application
import com.example.tmdbapp.BuildConfig
import com.example.tmdbapp.presentation.di.Injector
import com.example.tmdbapp.presentation.di.core.*
import com.example.tmdbapp.presentation.di.playingmovie.PlayingMovieSubComponent
import com.example.tmdbapp.presentation.di.popularmovie.PopularMovieSubComponent

class App : Application(),Injector {

    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createPopularMovieSubComponent(): PopularMovieSubComponent {
        return appComponent.popularMovieSubcomponent().create()
    }

    override fun createPlayingMovieSubComponent(): PlayingMovieSubComponent {
        return appComponent.playingMovieSubcomponent().create()
    }
}