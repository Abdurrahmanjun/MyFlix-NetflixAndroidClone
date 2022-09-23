package com.abdurrahmanjun.login.data.repository

import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.login.data.network.datasource.LoginDataSource
import com.abdurrahmanjun.login.data.network.model.request.LoginRequest
import com.abdurrahmanjun.shared.data.model.response.AuthResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
typealias LoginDataResource = DataResource<BaseResponse<AuthResponse>>

interface LoginRepository {
    suspend fun loginUser(
        email: String,
        password: String
    ): Flow<LoginDataResource>
}

class LoginRepositoryImpl(private val dataSource: LoginDataSource) : LoginRepository, Repository() {
    override suspend fun loginUser(email: String, password: String): Flow<LoginDataResource> {
        return flow {
            emit(safeNetworkCall { dataSource.loginUser(LoginRequest(email, password)) })
        }
    }
}