package com.example.moviecatalogue.ui.detail.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.core.domain.model.Movie
import com.example.moviecatalogue.core.ui.EpisodeAdapter
import com.example.moviecatalogue.databinding.ActivityDetailTvShowBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class DetailTvShowActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTvShowViewModel: DetailTvShowViewModel by viewModel()
    private lateinit var binding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailTvShow = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailTvShow(detailTvShow)

    }

    private fun showDetailTvShow(detailTvShow: Movie?) {
        val episodeAdapter = EpisodeAdapter()
        detailTvShow?.let {
            with(binding.detailContent){
                tvDetailTitle.text = detailTvShow.title
                tvDetailYear.text = dateFormat(detailTvShow.release)
                tvDetailRate.text = detailTvShow.rate.toString()
                tvDetailSinopsis.text = detailTvShow.overview
            }

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/original${detailTvShow.imageUrl}")
                .into(binding.imgDetailTvShow)

            var favStatus = detailTvShow.isFav
            setFavState(favStatus)
            binding.btnFav.setOnClickListener {
                favStatus = !favStatus
                detailTvShowViewModel.setFavoriteTvShow(detailTvShow, favStatus)
                setFavState(favStatus)

                if (favStatus){
                    Toast.makeText(this, getString(R.string.add_favorite), Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, getString(R.string.removed_favorite), Toast.LENGTH_SHORT).show()
                }
            }

            detailTvShowViewModel.getEpisode(detailTvShow.id).observe(this, { response ->
                episodeAdapter.setData(response)
            })

            with(binding.detailContent.rvEps){
                layoutManager = LinearLayoutManager(this@DetailTvShowActivity)
                setHasFixedSize(true)
                adapter = episodeAdapter
            }
        }
    }

    private fun setFavState(state: Boolean) {
        if (state){
            binding.btnFav.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            binding.btnFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
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
    }}