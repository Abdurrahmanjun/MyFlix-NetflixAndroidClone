package com.abdurrahmanjun.shared.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.abdurrahmanjun.shared.domain.AddOrRemoveWatchlistUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface AddOrRemoveWatchlistDelegates {
    fun init(scope: CoroutineScope)
    fun getWatchlistResult(): LiveData<ViewResource<MovieViewParam>>
    fun addOrRemoveWatchlist(movie: MovieViewParam)
}

class AddOrRemoveWatchlistDelegatesImpl : AddOrRemoveWatchlistDelegates {
    private lateinit var coroutineScope: CoroutineScope
    private val useCase: AddOrRemoveWatchlistUseCase by KoinJavaComponent.inject(
        AddOrRemoveWatchlistUseCase::class.java
    )
    private val result = MutableLiveData<ViewResource<MovieViewParam>>()

    override fun init(scope: CoroutineScope) {
        coroutineScope = scope
    }

    override fun getWatchlistResult(): LiveData<ViewResource<MovieViewParam>> {
        return result
    }

    override fun addOrRemoveWatchlist(movie: MovieViewParam) {
        coroutineScope.launch {
            useCase(AddOrRemoveWatchlistUseCase.Param(movie)).collect {
                result.postValue(it)
            }
        }
    }

}