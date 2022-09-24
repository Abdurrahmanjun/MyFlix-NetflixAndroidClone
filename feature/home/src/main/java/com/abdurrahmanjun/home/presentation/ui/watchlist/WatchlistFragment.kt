package com.abdurrahmanjun.home.presentation.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdurrahmanjun.core.base.BaseFragment
import com.abdurrahmanjun.home.R
import com.abdurrahmanjun.home.databinding.FragmentWatchlistBinding
import com.abdurrahmanjun.home.presentation.adapter.MovieAdapter
import com.abdurrahmanjun.home.presentation.ui.home.HomeViewModel
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class WatchlistFragment : BaseFragment<FragmentWatchlistBinding, HomeViewModel>(
    FragmentWatchlistBinding::inflate
) {

    override val viewModel: HomeViewModel by sharedViewModel()

    override fun initView() {
        setupRecyclerView()
        initData()
    }

    override fun observeData() {
        super.observeData()
    }

    private fun initData() {
        viewModel.getCurrentUser()
        viewModel.fetchHome()
    }

    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter(
            isGridLayout = true,
            itemClicked =  {
                Toast.makeText(
                    requireContext(),"cek",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }

    private fun setupRecyclerView() {
        binding.rvWatchlist.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}