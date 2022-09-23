package com.abdurrahmanjun.login.data.network.service

import com.abdurrahmanjun.login.data.network.model.request.LoginRequest
import com.abdurrahmanjun.shared.data.model.response.AuthResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface LoginFeatureApi {
    @POST("/api/v1/user/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): BaseResponse<AuthResponse>
}