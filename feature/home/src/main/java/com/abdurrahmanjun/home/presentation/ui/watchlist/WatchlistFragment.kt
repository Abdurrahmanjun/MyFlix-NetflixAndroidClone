package com.abdurrahmanjun.home.presentation.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdurrahmanjun.core.base.BaseFragment
import com.abdurrahmanjun.home.R
import com.abdurrahmanjun.home.databinding.FragmentWatchlistBinding
import com.abdurrahmanjun.home.presentation.adapter.MovieAdapter
import com.abdurrahmanjun.home.presentation.ui.home.HomeViewModel
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.abdurrahmanjun.shared.utils.ext.subscribe
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
        viewModel.watchlistResult.observe(this) {
            it.subscribe(
                doOnSuccess = { result ->
                    showLoading(false)
                    result.payload?.let { data ->
                        movieAdapter.setItems(data)
                    }
                },
                doOnLoading = {
                    showLoading(true)
                },
                doOnError = { error ->
                    showLoading(false)
                    error.exception?.let { e -> showError(true, e) }
                })
        }
    }

    private fun initData() {
        viewModel.getCurrentUser()
        viewModel.fetchWatchlist()
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
            layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }

    private fun showLoading(isShowLoading: Boolean) {
        binding.pbWatchlist.isVisible = isShowLoading
    }
}