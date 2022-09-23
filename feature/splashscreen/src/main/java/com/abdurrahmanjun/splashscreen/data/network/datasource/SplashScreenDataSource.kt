package com.abdurrahmanjun.splashscreen.data.network.datasource

import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.splashscreen.data.network.model.response.SyncResponse
import com.abdurrahmanjun.splashscreen.data.network.service.SplashScreenFeatureApi

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface SplashScreenDataSource {
    suspend fun doUserSync(): BaseResponse<SyncResponse>
}

class SplashScreenDataSourceImpl(val service: SplashScreenFeatureApi) : SplashScreenDataSource {
    override suspend fun doUserSync(): BaseResponse<SyncResponse> {
        return service.doUserSync()
    }
}