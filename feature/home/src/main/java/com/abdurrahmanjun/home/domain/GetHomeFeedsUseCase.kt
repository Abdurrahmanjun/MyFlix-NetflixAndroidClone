package com.abdurrahmanjun.home.domain

import com.abdurrahmanjun.core.base.BaseUseCase
import com.abdurrahmanjun.core.wrapper.ViewResource
import com.abdurrahmanjun.home.data.network.model.mapper.SectionMapper
import com.abdurrahmanjun.home.data.repository.HomeRepository
import com.abdurrahmanjun.home.presentation.viewparam.homeitem.HomeUiItem
import com.abdurrahmanjun.shared.data.model.mapper.MovieMapper
import com.abdurrahmanjun.shared.utils.ext.suspendSubscribe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class GetHomeFeedsUseCase(
    private val repository: HomeRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Nothing, List<HomeUiItem>>(dispatcher) {

    override suspend fun execute(param: Nothing?): Flow<ViewResource<List<HomeUiItem>>> = flow {
        emit(ViewResource.Loading())
        repository.fetchHomeFeeds().collect {
            it.suspendSubscribe(
                doOnSuccess = { result ->
                    val data = mutableListOf<HomeUiItem>()
                    result.payload?.data?.let { homeData ->
                        homeData.header?.let { movie ->
                            data.add(HomeUiItem.HeaderSectionItem(MovieMapper.toViewParam(movie)))
                        }
                        homeData.sections?.forEach { section ->
                            data.add(HomeUiItem.MovieSectionItem(SectionMapper.toViewParam(section)))
                        }
                    }
                    emit(ViewResource.Success(data))
                }, doOnError = { error ->
                    emit(ViewResource.Error(error.exception))
                }
            )
        }
    }
}