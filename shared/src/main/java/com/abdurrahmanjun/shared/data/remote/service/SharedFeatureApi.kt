package com.abdurrahmanjun.shared.data.remote.service

import com.abdurrahmanjun.shared.data.model.request.WatchlistRequest
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.POST

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface SharedFeatureApi {

    @POST("/api/v1/watchlist")
    suspend fun addWatchlist(@Body request: WatchlistRequest): BaseResponse<Any>

    @HTTP(method = "DELETE", path = "/api/v1/watchlist", hasBody = true)
    suspend fun removeWatchlist(@Body request: WatchlistRequest): BaseResponse<Any>

}