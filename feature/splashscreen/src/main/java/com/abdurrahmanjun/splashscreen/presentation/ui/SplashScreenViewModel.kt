package com.abdurrahmanjun.splashscreen.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.splashscreen.domain.SyncResult
import com.abdurrahmanjun.splashscreen.domain.SyncUserUseCase
import kotlinx.coroutines.launch

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class SplashScreenViewModel(private val syncUserUseCase: SyncUserUseCase) : ViewModel() {

    val syncResult : MutableLiveData<ViewResource<SyncResult>> = MutableLiveData()

    fun syncUser(){
        viewModelScope.launch {
            syncUserUseCase().collect{
                syncResult.value = it
            }
        }
    }

}