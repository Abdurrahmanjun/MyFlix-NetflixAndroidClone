package com.abdurrahmanjun.splashscreen.data.network.service

import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.splashscreen.data.network.model.response.SyncResponse
import retrofit2.http.GET

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface SplashScreenFeatureApi {
    @GET("/api/v1/sync")
    suspend fun doUserSync() : BaseResponse<SyncResponse>
}