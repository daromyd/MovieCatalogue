package com.example.moviecatalogue.ui.favorite.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.databinding.ItemTvshowBinding
import com.example.moviecatalogue.ui.detail.tvshow.DetailTvShowActivity

class FavTvShowAdapter : PagedListAdapter<TvShowEntity, FavTvShowAdapter.FavTvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavTvShowViewHolder {
        val itemFavTvShowBinding = ItemTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavTvShowViewHolder(itemFavTvShowBinding)
    }

    override fun onBindViewHolder(holder: FavTvShowViewHolder, position: Int) {
        val favTvShow = getItem(position)
        if (favTvShow != null){
            holder.bind(favTvShow)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    inner class FavTvShowViewHolder(private val binding: ItemTvshowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favTvShow: TvShowEntity){
            with(binding){
                tvItemTitle.text = favTvShow.title
                tvItemYear.text = favTvShow.year.toString()
                tvItemGenre.text = favTvShow.genre
                tvItemEps.text = itemView.resources.getString(R.string.episode, favTvShow.eps)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_ID, favTvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(favTvShow.poster)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgMovie)
            }
        }
    }
}