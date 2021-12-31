package com.example.tmdbapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbapp.R
import com.example.tmdbapp.databinding.ActivityPopularMoviesBinding

class PopularMoviesActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPopularMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movies)
    }
}