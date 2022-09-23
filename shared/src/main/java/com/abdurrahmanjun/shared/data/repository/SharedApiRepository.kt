package com.abdurrahmanjun.shared.data.repository

import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.shared.data.model.request.WatchlistRequest
import com.abdurrahmanjun.shared.data.remote.datasource.SharedFeatureApiDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface SharedApiRepository {
    suspend fun addWatchlist(movieId: String): Flow<DataResource<Any>>

    suspend fun removeWatchlist(movieId: String): Flow<DataResource<Any>>
}

class SharedApiRepositoryImpl(private val dataSource: SharedFeatureApiDataSource) : Repository(),
    SharedApiRepository {

    override suspend fun addWatchlist(movieId: String): Flow<DataResource<Any>> {
        return flow {
            emit(safeNetworkCall { dataSource.addWatchlist(WatchlistRequest(movieId)) })
        }
    }

    override suspend fun removeWatchlist(movieId: String): Flow<DataResource<Any>> {
        return flow {
            emit(safeNetworkCall { dataSource.removeWatchlist(WatchlistRequest(movieId)) })
        }
    }

}