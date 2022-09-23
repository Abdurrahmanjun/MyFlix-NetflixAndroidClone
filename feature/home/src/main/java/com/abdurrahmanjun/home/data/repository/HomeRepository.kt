package com.abdurrahmanjun.home.data.repository

import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.home.data.network.datasource.HomeDataSource
import com.abdurrahmanjun.home.data.network.model.response.HomeFeedsResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.model.response.MovieResponse
import com.abdurrahmanjun.shared.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
typealias HomeDataResource = DataResource<BaseResponse<HomeFeedsResponse>>
typealias WatchlistDataResource = DataResource<BaseResponse<List<MovieResponse>>>

interface HomeRepository {

    suspend fun fetchHomeFeeds(): Flow<HomeDataResource>

    suspend fun fetchWatchlist(): Flow<WatchlistDataResource>
}

class HomeRepositoryImpl(private val dataSource: HomeDataSource) : Repository(), HomeRepository {
    override suspend fun fetchHomeFeeds(): Flow<HomeDataResource> = flow {
        emit(safeNetworkCall { dataSource.fetchHomeFeeds() })
    }

    override suspend fun fetchWatchlist(): Flow<WatchlistDataResource> = flow {
        emit(safeNetworkCall { dataSource.fetchWatchlist() })
    }

}