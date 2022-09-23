package com.abdurrahmanjun.shared.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.shared.data.model.response.UserResponse
import com.abdurrahmanjun.shared.data.repository.UserPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class SaveAuthDataUseCase(
    private val repository: UserPreferenceRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<SaveAuthDataUseCase.Param, Boolean>(dispatcher) {

    override suspend fun execute(param: Param?): Flow<ViewResource<Boolean>> = flow {
        param?.let {
            val saveLoginStatus = repository.updateUserLoginStatus(param.isLoggedIn).first()
            val saveToken = repository.updateUserToken(param.authToken).first()
            val saveUser = repository.setCurrentUser(param.user).first()

            if (saveUser is DataResource.Success && saveToken is DataResource.Success && saveLoginStatus is DataResource.Success) {
                emit(ViewResource.Success(true))
            } else {
                emit(ViewResource.Error(IllegalStateException("Failed to save local data")))
            }
        }
    }

    data class Param(val isLoggedIn: Boolean, val authToken: String, val user: UserResponse)
}