package com.abdurrahmanjun.login.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.login.domain.LoginUserUseCase
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import kotlinx.coroutines.launch

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class LoginViewModel(private val loginUserUseCase: LoginUserUseCase) : ViewModel() {
    val loginResult = MutableLiveData<ViewResource<UserViewParam?>>()

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            loginUserUseCase(LoginUserUseCase.Param(email, password)).collect {
                loginResult.postValue(it)
            }
        }
    }
}