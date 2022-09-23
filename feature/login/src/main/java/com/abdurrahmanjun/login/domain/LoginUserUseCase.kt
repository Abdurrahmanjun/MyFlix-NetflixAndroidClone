package com.abdurrahmanjun.login.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.login.data.repository.LoginRepository
import com.abdurrahmanjun.shared.data.model.mapper.UserMapper
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import com.abdurrahmanjun.shared.domain.SaveAuthDataUseCase
import com.abdurrahmanjun.shared.utils.ext.suspendSubscribe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class LoginUserUseCase(
    private val checkLoginFieldUseCase: CheckLoginFieldUseCase,
    private val saveAuthDataUseCase: SaveAuthDataUseCase,
    private val repository: LoginRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<LoginUserUseCase.Param, UserViewParam?>(dispatcher) {

    override suspend fun execute(param: Param?): Flow<ViewResource<UserViewParam?>> {

        return flow {
            param?.let {
                emit(ViewResource.Loading())
                checkLoginFieldUseCase(param).first().suspendSubscribe(
                    doOnSuccess = { _ ->
                        repository.loginUser(param.email, param.password).collect { loginResult ->
                            loginResult.suspendSubscribe(
                                doOnSuccess = {
                                    val result = loginResult.payload?.data
                                    val token = result?.token
                                    val user = result?.user
                                    if (!token.isNullOrEmpty() && user != null) {
                                        saveAuthDataUseCase(
                                            SaveAuthDataUseCase.Param(true, token, user)
                                        ).collect {
                                            it.suspendSubscribe(
                                                doOnSuccess = {
                                                    emit(ViewResource.Success(UserMapper.toViewParam(user)))
                                                },
                                                doOnError = { error ->
                                                    emit(ViewResource.Error(error.exception))
                                                }
                                            )
                                        }
                                    }
                                },doOnError = { error ->
                                    emit(ViewResource.Error(error.exception))
                                })
                        }
                    },
                    doOnError = { error ->
                        emit(ViewResource.Error(error.exception))
                    }
                )
            } ?: throw IllegalStateException("Param Required")
        }

    }

    data class Param(val email: String, val password: String)
}