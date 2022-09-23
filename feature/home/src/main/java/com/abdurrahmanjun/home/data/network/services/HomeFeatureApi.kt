package com.abdurrahmanjun.home.data.network.services

import com.abdurrahmanjun.home.data.network.model.response.HomeFeedsResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.model.response.MovieResponse
import retrofit2.http.GET

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface HomeFeatureApi {

    @GET("api/v1/homepage")
    suspend fun fetchHomeFeeds(): BaseResponse<HomeFeedsResponse>

    @GET("api/v1/watchlist")
    suspend fun fetchWatchlist(): BaseResponse<List<MovieResponse>>

}