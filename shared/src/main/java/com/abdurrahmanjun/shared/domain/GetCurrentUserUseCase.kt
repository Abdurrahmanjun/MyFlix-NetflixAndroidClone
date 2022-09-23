package com.abdurrahmanjun.shared.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.DataResource
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.shared.data.model.mapper.UserMapper
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import com.abdurrahmanjun.shared.data.repository.UserPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class GetCurrentUserUseCase(
    private val repository: UserPreferenceRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Nothing, UserViewParam>(dispatcher) {

    override suspend fun execute(param: Nothing?): Flow<ViewResource<UserViewParam>> =
        repository.getCurrentUser().map {
            when (it) {
                is DataResource.Success -> {
                    ViewResource.Success(UserMapper.toViewParam(it.payload))
                }
                is DataResource.Error -> {
                    ViewResource.Error(it.exception)
                }
            }
        }
}