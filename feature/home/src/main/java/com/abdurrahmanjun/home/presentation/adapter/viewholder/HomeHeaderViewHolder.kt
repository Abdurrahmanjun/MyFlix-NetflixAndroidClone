package com.abdurrahmanjun.home.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.abdurrahmanjun.home.databinding.ItemHeaderHomeBinding
import com.abdurrahmanjun.home.presentation.adapter.HomeAdapterClickListener
import com.abdurrahmanjun.home.presentation.viewparam.homeitem.HomeUiItem
import com.abdurrahmanjun.shared.utils.CommonUtils

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class HomeHeaderViewHolder(
    private val binding: ItemHeaderHomeBinding,
    private val listener: HomeAdapterClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: HomeUiItem.HeaderSectionItem) {
        with(item.movieViewParam) {
            binding.tvAddToWatchlistHeader.setCompoundDrawablesWithIntrinsicBounds(
                0,
                CommonUtils.getWatchlistIcon(isUserWatchlist), 0, 0
            )
            binding.ivHeaderMovie.load(this.posterUrl)
            binding.tvTitleMovie.text = this.title
            binding.tvInfoHeader.setOnClickListener {
                listener.onMovieClicked(this)
            }
            binding.tvAddToWatchlistHeader.setOnClickListener {
                listener.onMyListClicked(this)
            }
            binding.cvPlayHeader.setOnClickListener {
                listener.onPlayMovieClicked(this)
            }
        }
    }

}