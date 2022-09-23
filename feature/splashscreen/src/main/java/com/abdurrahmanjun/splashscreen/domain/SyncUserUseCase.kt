package com.abdurrahmanjun.splashscreen.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.shared.data.model.mapper.UserMapper
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import com.abdurrahmanjun.shared.data.repository.UserPreferenceRepository
import com.abdurrahmanjun.shared.utils.ext.suspendSubscribe
import com.abdurrahmanjun.splashscreen.data.repository.SplashScreenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
typealias SyncResult = Pair<Boolean, UserViewParam?>

class SyncUserUseCase(
    private val splashScreenRepository: SplashScreenRepository,
    private val userPreferenceRepository: UserPreferenceRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Nothing, SyncResult>(dispatcher) {

    override suspend fun execute(param: Nothing?): Flow<ViewResource<SyncResult>> {
        return flow {
            userPreferenceRepository.isUserLoggedIn().first().suspendSubscribe(
                doOnSuccess = { result ->
                    if (result.payload == true) {
                        splashScreenRepository.doUserSync().collect {
                            it.suspendSubscribe(
                                doOnSuccess = { response ->
                                    emit(ViewResource.Success(Pair(true, UserMapper.toViewParam(response.payload?.data?.userResponse))))
                                }, doOnError = { error ->
                                    emit(ViewResource.Error(error.exception))
                                })
                        }
                    } else {
                        emit(
                            ViewResource.Success(Pair(false, null))
                        )
                    }
                },
                doOnError = { error ->
                    emit(ViewResource.Error(error.exception))
                })
        }
    }
}