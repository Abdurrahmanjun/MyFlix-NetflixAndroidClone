package com.abdurrahmanjun.shared.data.remote.datasource

import com.abdurrahmanjun.shared.data.model.request.WatchlistRequest
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.remote.service.SharedFeatureApi

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface SharedFeatureApiDataSource {
    suspend fun addWatchlist(request: WatchlistRequest): BaseResponse<Any>
    suspend fun removeWatchlist(request: WatchlistRequest): BaseResponse<Any>
}

class SharedFeatureApiDataSourceImpl(private val sharedFeatureApi: SharedFeatureApi) :
    SharedFeatureApiDataSource {
    override suspend fun addWatchlist(request: WatchlistRequest): BaseResponse<Any> {
        return sharedFeatureApi.addWatchlist(request)
    }

    override suspend fun removeWatchlist(request: WatchlistRequest): BaseResponse<Any> {
        return sharedFeatureApi.removeWatchlist(request)
    }

}