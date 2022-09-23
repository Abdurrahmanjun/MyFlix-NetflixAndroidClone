package com.abdurrahmanjun.login.data.network.datasource

import com.abdurrahmanjun.login.data.network.model.request.LoginRequest
import com.abdurrahmanjun.login.data.network.service.LoginFeatureApi
import com.abdurrahmanjun.shared.data.model.response.AuthResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface LoginDataSource {
    suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<AuthResponse>
}

class LoginDataSourceImpl(private val api: LoginFeatureApi) : LoginDataSource {
    override suspend fun loginUser(loginRequest: LoginRequest): BaseResponse<AuthResponse> {
        return api.loginUser(loginRequest)
    }
}