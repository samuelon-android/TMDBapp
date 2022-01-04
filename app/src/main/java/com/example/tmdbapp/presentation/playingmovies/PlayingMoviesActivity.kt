package com.example.tmdbapp.presentation.playingmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbapp.R
import com.example.tmdbapp.databinding.ActivityPlayingMoviesBinding
import com.example.tmdbapp.presentation.di.Injector
import com.example.tmdbapp.presentation.popularmovies.PopularMoviesViewModel
import javax.inject.Inject

class PlayingMoviesActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: PlayingMovieViewModelFactory
    private lateinit var playingMoviesViewModel: PlayingMoviesViewModel

    private lateinit var adapter: PlayingMovieAdapter

    private lateinit var binding: ActivityPlayingMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_playing_movies)

        (application as Injector).createPlayingMovieSubComponent().inject(this)

        playingMoviesViewModel = ViewModelProvider(this,factory).get(PlayingMoviesViewModel::class.java)

        initRecycleView()
    }

    private fun initRecycleView(){
        adapter = PlayingMovieAdapter()
        binding.apply {
            recyclePlayingMovies.layoutManager = LinearLayoutManager(applicationContext)
            recyclePlayingMovies.adapter = adapter
        }
        displayPlayingMovies()
    }

    private fun displayPlayingMovies(){
        binding.progressBarPlayingMovies.visibility = View.VISIBLE
        val responseLiveData = playingMoviesViewModel.get_playingMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarPlayingMovies.visibility = View.GONE
            }else{
                binding.progressBarPlayingMovies.visibility = View.GONE
                Toast.makeText(applicationContext,getString(R.string.error), Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update_icon -> {
                updatePlayingMovies()
                true
            }else ->super.onOptionsItemSelected(item)
        }
    }

    private fun updatePlayingMovies(){
        binding.progressBarPlayingMovies.visibility = View.VISIBLE
        val response = playingMoviesViewModel.update_playingMovies()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarPlayingMovies.visibility = View.GONE
            }else{
                binding.progressBarPlayingMovies.visibility = View.GONE
            }
        })
    }
}