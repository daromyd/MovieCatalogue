package com.example.moviecatalogue.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecatalogue.core.ui.MoviesAdapter
import com.example.moviecatalogue.favorite.databinding.FragmentFavTvShowBinding
import com.example.moviecatalogue.favorite.favoriteModule
import com.example.moviecatalogue.ui.detail.tvshow.DetailTvShowActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavTvShowFragment : Fragment() {

    private val favTvShowViewModel: FavTvShowViewModel by viewModel()
    private var _binding: FragmentFavTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadKoinModules(favoriteModule)

        if (activity != null){
            val favTvShowAdapter = MoviesAdapter()
            favTvShowAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favTvShowViewModel.favoriteTvShow.observe(viewLifecycleOwner, { data ->
                favTvShowAdapter.setData(data)
                binding.viewEmpty.root.visibility = if (data.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvFavTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = favTvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}