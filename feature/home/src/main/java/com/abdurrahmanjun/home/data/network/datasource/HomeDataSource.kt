package com.abdurrahmanjun.home.data.network.datasource

import com.abdurrahmanjun.home.data.network.model.response.HomeFeedsResponse
import com.abdurrahmanjun.home.data.network.services.HomeFeatureApi
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.model.response.MovieResponse

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface HomeDataSource {
    suspend fun fetchHomeFeeds(): BaseResponse<HomeFeedsResponse>

    suspend fun fetchWatchlist(): BaseResponse<List<MovieResponse>>
}

class HomeDataSourceImpl(private val api: HomeFeatureApi) : HomeDataSource {
    override suspend fun fetchHomeFeeds(): BaseResponse<HomeFeedsResponse> {
        return api.fetchHomeFeeds()
    }

    override suspend fun fetchWatchlist(): BaseResponse<List<MovieResponse>> {
        return api.fetchWatchlist()
    }

}