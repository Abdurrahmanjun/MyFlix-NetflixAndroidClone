package com.abdurrahmanjun.register.data.repository

import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.register.data.network.datasource.RegisterDataSource
import com.abdurrahmanjun.register.data.network.model.request.RegisterRequest
import com.abdurrahmanjun.shared.data.model.response.AuthResponse
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.abdurrahmanjun.shared.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */

typealias RegisterDataResource = DataResource<BaseResponse<AuthResponse>>

interface RegisterRepository {
    suspend fun registerUser(
        birthdate: String,
        email: String,
        gender: String,
        password: String,
        username: String
    ): Flow<RegisterDataResource>
}

class RegisterRepositoryImpl(private val dataSource: RegisterDataSource) : RegisterRepository,
    Repository() {
    override suspend fun registerUser(
        birthdate: String,
        email: String,
        gender: String,
        password: String,
        username: String
    ): Flow<RegisterDataResource> {
        return flow {
            emit(safeNetworkCall {
                dataSource.registerUser(
                    RegisterRequest(
                        email = email,
                        username = username,
                        password = password,
                        gender = gender,
                        birthdate = birthdate
                    )
                )
            })
        }
    }

}