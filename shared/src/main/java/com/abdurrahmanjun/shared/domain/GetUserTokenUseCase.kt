package com.abdurrahmanjun.shared.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.shared.data.repository.UserPreferenceRepository
import com.abdurrahmanjun.shared.utils.ext.suspendSubscribe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class GetUserTokenUseCase(
    private val repository: UserPreferenceRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Nothing, String>(dispatcher) {

    override suspend fun execute(param: Nothing?): Flow<ViewResource<String>> {
        return flow {
            repository.getUserToken().collect{
                it.suspendSubscribe(doOnSuccess = { result ->
                    emit(ViewResource.Success(result.payload.orEmpty()))
                }, doOnError = { error ->
                    emit(ViewResource.Error(error.exception))
                })
            }
        }
    }
}