package com.example.moviecatalogue.ui.detail.tvshow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.example.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.example.moviecatalogue.viewModel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class DetailTvShowActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var contentBinding: ContentDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailTvShowAdapter()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val tvShowId = extras.getString(EXTRA_ID)
            if (tvShowId != null){

                activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                activityDetailTvShowBinding.appBar.visibility = View.GONE
                activityDetailTvShowBinding.content.visibility = View.GONE

                viewModel.selectedTvShow(tvShowId)

                viewModel.tvShowEpisode.observe(this, { tvShowWithEpisodeResource ->
                    if (tvShowWithEpisodeResource != null){
                        when(tvShowWithEpisodeResource.status){
                            Status.LOADING -> activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (tvShowWithEpisodeResource.data != null) {
                                activityDetailTvShowBinding.progressBar.visibility = View.GONE
                                activityDetailTvShowBinding.appBar.visibility = View.VISIBLE
                                activityDetailTvShowBinding.content.visibility = View.VISIBLE

                                val mData = tvShowWithEpisodeResource.data
                                adapter.setEpisodes(mData.mEpisode)
                                adapter.notifyDataSetChanged()
                                populateTvShow(mData.mTvShow)
                                setFavState(mData.mTvShow.isFav)

                                activityDetailTvShowBinding.btnFav.setOnClickListener {
                                    if (tvShowWithEpisodeResource.data.mTvShow.isFav){
                                        Toast.makeText(this, "${mData.mTvShow.title} remove from favorite!", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(this, "${mData.mTvShow.title} added to favorite!", Toast.LENGTH_SHORT).show()
                                    }
                                    viewModel.setFav()
                                }
                            }
                            Status.ERROR -> {
                                activityDetailTvShowBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }
        }

        with(contentBinding.rvEps){
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@DetailTvShowActivity)
        }

    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        with(contentBinding){
            tvDetailTitle.text = tvShowEntity.title
            tvDetailYear.text = tvShowEntity.year.toString()
            tvDetailEpisode.text = resources.getString(R.string.episode, tvShowEntity.eps)
            tvDetailGenre.text = tvShowEntity.genre
            tvDetailRate.text = tvShowEntity.rating.toString()
            tvDetailSinopsis.text = tvShowEntity.sinopsis
        }

        Glide.with(this)
                .load(tvShowEntity.poster)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(activityDetailTvShowBinding.imgDetailTvShow)
    }

    private fun setFavState(state: Boolean) {
        if (state){
            activityDetailTvShowBinding.btnFav.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            activityDetailTvShowBinding.btnFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}