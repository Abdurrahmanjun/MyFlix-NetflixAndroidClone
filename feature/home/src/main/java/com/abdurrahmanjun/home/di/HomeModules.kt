package com.abdurrahmanjun.home.di

import com.abdurrahmanjun.core.base.FeatureModules
import com.abdurrahmanjun.home.data.network.datasource.HomeDataSource
import com.abdurrahmanjun.home.data.network.datasource.HomeDataSourceImpl
import com.abdurrahmanjun.home.data.network.services.HomeFeatureApi
import com.abdurrahmanjun.home.data.repository.HomeRepository
import com.abdurrahmanjun.home.data.repository.HomeRepositoryImpl
import com.abdurrahmanjun.home.domain.GetHomeFeedsUseCase
import com.abdurrahmanjun.home.domain.GetUserWatchlistUseCase
import com.abdurrahmanjun.home.presentation.ui.home.HomeViewModel
import com.abdurrahmanjun.shared.data.remote.NetworkClient
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object HomeModules : FeatureModules {

    override fun getModules(): List<Module> =
        listOf(repositories, viewModels, dataSources, useCases, network)

    override val repositories: Module = module {
        single<HomeRepository> { HomeRepositoryImpl(get()) }
    }

    override val viewModels: Module = module {
        viewModelOf(::HomeViewModel)
    }

    override val dataSources: Module = module {
        single<HomeDataSource> { HomeDataSourceImpl(get()) }
    }

    override val useCases: Module = module {
        single { GetHomeFeedsUseCase(get(), Dispatchers.IO) }
        single { GetUserWatchlistUseCase(get(), Dispatchers.IO) }
    }

    override val network: Module = module {
        single<HomeFeatureApi> { get<NetworkClient>().create() }
    }

}