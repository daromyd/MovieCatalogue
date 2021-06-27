package com.example.moviecatalogue.ui.detail.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.example.moviecatalogue.databinding.ContentDetailMovieBinding
import com.example.moviecatalogue.viewModel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var contentBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val movieId = extras.getString(EXTRA_ID)
            if (movieId != null){

                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                activityDetailMovieBinding.appBar.visibility = View.GONE
                activityDetailMovieBinding.content.visibility = View.GONE

                viewModel.setSelectedMovie(movieId)

                viewModel.getMovie().observe(this, { movie ->
                    if (movie != null){
                        activityDetailMovieBinding.progressBar.visibility = View.GONE
                        activityDetailMovieBinding.appBar.visibility = View.VISIBLE
                        activityDetailMovieBinding.content.visibility = View.VISIBLE

                        populateMovie(movie)

                        setFavState(movie.isFav)

                        activityDetailMovieBinding.btnFavMovie.setOnClickListener {
                            if (movie.isFav){
                                Toast.makeText(this, "${movie.title} remove from favorite!", Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(this, "${movie.title} added to favorite!", Toast.LENGTH_SHORT).show()
                            }
                            viewModel.setFavMovie(movie)
                        }
                    }
                })

            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        with(contentBinding){
            tvDetailTitle.text = movieEntity.title
            tvDetailYear.text = movieEntity.year.toString()
            tvDetailDuration.text = resources.getString(R.string.duration, movieEntity.duration)
            tvDetailGenre.text = movieEntity.genre
            tvDetailRate.text = movieEntity.rating.toString()
            tvDetailSinopsis.text = movieEntity.sinopsis
        }

        Glide.with(this)
                .load(movieEntity.poster)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(activityDetailMovieBinding.imgDetailMovie)
    }

    private fun setFavState(state: Boolean) {
        if (state){
            activityDetailMovieBinding.btnFavMovie.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            activityDetailMovieBinding.btnFavMovie.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}