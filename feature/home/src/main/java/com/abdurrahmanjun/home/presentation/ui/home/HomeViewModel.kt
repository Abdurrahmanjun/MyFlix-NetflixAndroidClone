package com.abdurrahmanjun.home.presentation.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.home.domain.GetHomeFeedsUseCase
import com.abdurrahmanjun.home.domain.GetUserWatchlistUseCase
import com.abdurrahmanjun.home.presentation.viewparam.homeitem.HomeUiItem
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import com.abdurrahmanjun.shared.di.AddOrRemoveWatchlistDelegates
import com.abdurrahmanjun.shared.di.AddOrRemoveWatchlistDelegatesImpl
import com.abdurrahmanjun.shared.domain.GetCurrentUserUseCase
import kotlinx.coroutines.launch

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class HomeViewModel(
    private val getHomeFeedsUseCase: GetHomeFeedsUseCase,
    private val getUserWatchlistUseCase: GetUserWatchlistUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase
) : ViewModel(), AddOrRemoveWatchlistDelegates by AddOrRemoveWatchlistDelegatesImpl() {

    val homeFeedsResult = MutableLiveData<ViewResource<List<HomeUiItem>>>()
    val watchlistResult = MutableLiveData<ViewResource<List<MovieViewParam>>>()
    val currentUserResult = MutableLiveData<ViewResource<UserViewParam>>()

    init {
        init(viewModelScope)
    }

    fun fetchHome() {
        viewModelScope.launch {
            getHomeFeedsUseCase().collect {
                homeFeedsResult.postValue(it)
            }
        }
    }

    fun getCurrentUser() {
        viewModelScope.launch {
            getCurrentUserUseCase().collect {
                currentUserResult.postValue(it)
            }
        }
    }

    fun fetchWatchlist() {
        viewModelScope.launch {
            getUserWatchlistUseCase().collect {
                watchlistResult.postValue(it)
            }
        }
    }
}