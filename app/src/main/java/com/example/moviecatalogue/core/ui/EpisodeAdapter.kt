package com.example.moviecatalogue.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.core.domain.model.Episode
import com.example.moviecatalogue.databinding.ItemEpisodeListBinding
import java.util.*

class EpisodeAdapter: RecyclerView.Adapter<EpisodeAdapter.ListViewHolder>() {

    private var listData = ArrayList<Episode>()
    var onItemClick: ((Episode) -> Unit)? = null

    fun setData(newListData: List<Episode>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_episode_list, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemEpisodeListBinding.bind(itemView)
        fun bind(data: Episode) {
            with(binding){
                if (data.imageUrl?.isNotEmpty() == true){
                    Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/original" + data.imageUrl)
                        .into(imgMovie)
                }else{
                    imgMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_no_imge))
                }

                tvItemEpisodeTitle.text = "${data.episodeNumber}. ${data.title}"
                tvItemOverview.text = data.overview
            }
        }

    }

}