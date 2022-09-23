package com.abdurrahmanjun.shared.di

import com.abdurrahmanjun.core.base.BaseModules
import com.abdurrahmanjun.shared.data.local.datastore.UserPreferenceDataSource
import com.abdurrahmanjun.shared.data.local.datastore.UserPreferenceDataSourceImpl
import com.abdurrahmanjun.shared.data.local.datastore.UserPreferenceFactory
import com.abdurrahmanjun.shared.data.remote.NetworkClient
import com.abdurrahmanjun.shared.data.remote.datasource.SharedFeatureApiDataSource
import com.abdurrahmanjun.shared.data.remote.datasource.SharedFeatureApiDataSourceImpl
import com.abdurrahmanjun.shared.data.remote.service.SharedFeatureApi
import com.abdurrahmanjun.shared.data.repository.SharedApiRepository
import com.abdurrahmanjun.shared.data.repository.SharedApiRepositoryImpl
import com.abdurrahmanjun.shared.data.repository.UserPreferenceRepository
import com.abdurrahmanjun.shared.data.repository.UserPreferenceRepositoryImpl
import com.abdurrahmanjun.shared.domain.AddOrRemoveWatchlistUseCase
import com.abdurrahmanjun.shared.domain.GetCurrentUserUseCase
import com.abdurrahmanjun.shared.domain.GetUserTokenUseCase
import com.abdurrahmanjun.shared.domain.SaveAuthDataUseCase
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object SharedModules : BaseModules {
    override fun getModules(): List<Module> =
        listOf(remote, local, dataSource, repository, sharedUseCase, common)

    private val remote = module {
        single { ChuckerInterceptor.Builder(androidContext()).build() }
        single { NetworkClient(get(), get()) }
        single<SharedFeatureApi> { get<NetworkClient>().create() }
    }

    private val local = module {
        single { UserPreferenceFactory(androidContext()).create() }
    }

    private val dataSource = module {
        single<UserPreferenceDataSource> { UserPreferenceDataSourceImpl(get(), get()) }
        single<SharedFeatureApiDataSource> { SharedFeatureApiDataSourceImpl(get()) }
    }

    private val repository = module {
        single<UserPreferenceRepository> { UserPreferenceRepositoryImpl(get()) }
        single<SharedApiRepository> { SharedApiRepositoryImpl(get()) }
    }
    private val sharedUseCase = module {
        single { GetUserTokenUseCase(get(), Dispatchers.IO) }
        single { SaveAuthDataUseCase(get(), Dispatchers.IO) }
        single { AddOrRemoveWatchlistUseCase(get(), Dispatchers.IO) }
        single { GetCurrentUserUseCase(get(), Dispatchers.IO) }
    }
    private val common = module {
        single { Gson() }
    }
}