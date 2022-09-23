package com.abdurrahmanjun.register.data.network.datasource

import com.abdurrahmanjun.register.data.network.model.request.RegisterRequest
import com.abdurrahmanjun.register.data.network.services.RegisterFeatureApi
import com.abdurrahmanjun.shared.data.model.response.AuthResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface RegisterDataSource {
    suspend fun registerUser(registerRequest: RegisterRequest): BaseResponse<AuthResponse>
}

class RegisterDataSourceImpl(private val api: RegisterFeatureApi) : RegisterDataSource {
    override suspend fun registerUser(registerRequest: RegisterRequest): BaseResponse<AuthResponse> {
        return api.registerUser(registerRequest)
    }
}