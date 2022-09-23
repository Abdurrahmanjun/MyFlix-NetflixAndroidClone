package com.abdurrahmanjun.register.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.register.domain.RegisterUserUseCase
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import kotlinx.coroutines.launch

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class RegisterViewModel(private val registerUserUseCase: RegisterUserUseCase) : ViewModel() {

    val registerResult = MutableLiveData<ViewResource<UserViewParam?>>()

    fun registerUser(
        birthdate: String,
        email: String,
        gender: String,
        password: String,
        username: String
    ) {
        viewModelScope.launch {
            registerUserUseCase(
                RegisterUserUseCase.RegisterParam(
                    email = email,
                    password = password,
                    gender = gender,
                    birthdate = birthdate,
                    username = username
                )
            ).collect {
                registerResult.postValue(it)
            }
        }
    }

}