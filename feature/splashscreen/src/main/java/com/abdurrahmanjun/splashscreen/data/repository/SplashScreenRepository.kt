package com.abdurrahmanjun.splashscreen.data.repository

import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.repository.Repository
import com.abdurrahmanjun.splashscreen.data.network.datasource.SplashScreenDataSource
import com.abdurrahmanjun.splashscreen.data.network.model.response.SyncResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */

typealias SyncDataResponse = DataResource<BaseResponse<SyncResponse>>

interface SplashScreenRepository {
    suspend fun doUserSync(): Flow<SyncDataResponse>
}

class SplashScreenRepositoryImpl(val dataSource: SplashScreenDataSource) : SplashScreenRepository,
    Repository() {
    override suspend fun doUserSync(): Flow<SyncDataResponse> {
        return flow {
            emit(safeNetworkCall { dataSource.doUserSync() })
        }
    }
}