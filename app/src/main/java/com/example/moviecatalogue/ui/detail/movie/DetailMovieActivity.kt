package com.example.moviecatalogue.ui.detail.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.databinding.ActivityDetailMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class DetailMovieActivity : AppCompatActivity() {

    private val detailMovieViewModel : DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            with(binding.detailContent){
                tvDetailTitle.text = detailMovie.title
                tvDetailYear.text = dateFormat(detailMovie.release)
                tvDetailRate.text = detailMovie.rate.toString()
                tvDetailSinopsis.text = detailMovie.overview
            }

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/original${detailMovie.imageUrl}")
                .into(binding.imgDetailMovie)

            var favStatus = detailMovie.isFav
            setFavState(favStatus)
            binding.btnFavMovie.setOnClickListener {
                favStatus = !favStatus
                detailMovieViewModel.setFavoriteMovie(detailMovie, favStatus)
                setFavState(favStatus)
                if (favStatus){
                    Toast.makeText(this, getString(R.string.add_favorite), Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, getString(R.string.removed_favorite), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setFavState(state: Boolean) {
        if (state){
            binding.btnFavMovie.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            binding.btnFavMovie.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @SuppressLint("SimpleDateFormat")
    private fun dateFormat(date: String): String{
        val cutFormatter = SimpleDateFormat("yyyy-MM-dd")
        val dateObject = cutFormatter.parse(date)
        val postFormatter = SimpleDateFormat("dd MMMM yyyy")
        return postFormatter.format(dateObject!!)
    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}