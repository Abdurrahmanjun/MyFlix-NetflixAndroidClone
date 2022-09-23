package com.abdurrahmanjun.register.data.network.services

import com.abdurrahmanjun.register.data.network.model.request.RegisterRequest
import com.abdurrahmanjun.shared.data.model.response.AuthResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface RegisterFeatureApi {
    @POST("/api/v1/user/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): BaseResponse<AuthResponse>
}