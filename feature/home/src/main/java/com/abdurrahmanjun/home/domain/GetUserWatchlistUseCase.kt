package com.abdurrahmanjun.home.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.home.data.repository.HomeRepository
import com.abdurrahmanjun.shared.data.model.mapper.MovieMapper
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.abdurrahmanjun.shared.utils.ext.suspendSubscribe
import com.abdurrahmanjun.shared.utils.mapper.ListMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class GetUserWatchlistUseCase(
    private val repository: HomeRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Nothing, List<MovieViewParam>>(dispatcher) {

    override suspend fun execute(param: Nothing?): Flow<ViewResource<List<MovieViewParam>>> {
        return flow {
            emit(ViewResource.Loading())
            repository.fetchWatchlist().collect {
                it.suspendSubscribe(
                    doOnSuccess = { response ->
                        val movies = response.payload?.data
                        if (movies.isNullOrEmpty()) {
                            emit(ViewResource.Empty())
                        } else {
                            emit(ViewResource.Success(ListMapper(MovieMapper).toViewParams(movies)))
                        }
                    },
                    doOnError = { error ->
                        emit(ViewResource.Error(error.exception))
                    }
                )
            }
        }
    }
}