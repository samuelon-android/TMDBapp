package com.example.tmdbapp.presentation.popularmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.example.tmdbapp.databinding.ActivityPopularMoviesBinding
import com.example.tmdbapp.presentation.di.Injector
import javax.inject.Inject

class PopularMoviesActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: PopularMovieViewModelFactory
    private lateinit var popularMoviesViewModel: PopularMoviesViewModel

    private lateinit var binding:ActivityPopularMoviesBinding
    private lateinit var adapter:PopularMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movies)
        (application as Injector).createPopularMovieSubComponent().inject(this)

        popularMoviesViewModel = ViewModelProvider(this,factory).get(PopularMoviesViewModel::class.java)

        initRecycleView()

    }

    private fun initRecycleView(){
        adapter = PopularMovieAdapter()
        binding.apply {
            recyclePopulaMovies.layoutManager = LinearLayoutManager(applicationContext)
            recyclePopulaMovies.adapter = adapter
        }
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.progressBarPopularMovies.visibility = View.VISIBLE
        val responseLiveData = popularMoviesViewModel.get_popularMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarPopularMovies.visibility = View.GONE
            }else{
                binding.progressBarPopularMovies.visibility = View.GONE
                Toast.makeText(applicationContext,getString(R.string.error),Toast.LENGTH_LONG).show()
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
                updatePopularMovies()
                true
            }else ->super.onOptionsItemSelected(item)
        }
    }

    private fun updatePopularMovies(){
        binding.progressBarPopularMovies.visibility = View.VISIBLE
        val response = popularMoviesViewModel.update_popularMovies()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarPopularMovies.visibility = View.GONE
            }else{
                binding.progressBarPopularMovies.visibility = View.GONE
            }
        })
    }
}