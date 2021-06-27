package com.example.moviecatalogue.ui.detail.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.EpisodeEntity
import com.example.moviecatalogue.databinding.ItemEpisodeListBinding

class DetailTvShowAdapter : RecyclerView.Adapter<DetailTvShowAdapter.EpsViewHolder>() {
    private val listEpisodes = ArrayList<EpisodeEntity>()

    fun setEpisodes(episodes: List<EpisodeEntity>?){
        if (episodes == null) return
        this.listEpisodes.clear()
        this.listEpisodes.addAll(episodes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpsViewHolder {
        val itemEpisodeListBinding = ItemEpisodeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpsViewHolder(itemEpisodeListBinding)
    }

    override fun onBindViewHolder(holder: EpsViewHolder, position: Int) {
        val episode =  listEpisodes[position]
        holder.bind(episode)
    }

    override fun getItemCount(): Int = listEpisodes.size

    inner class EpsViewHolder(private val binding: ItemEpisodeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeEntity){
            with(binding){
                tvItemEpisodeTitle.text = episode.title
                tvItemDuration.text = itemView.resources.getString(R.string.duration, episode.duration)
            }
        }

    }

}
