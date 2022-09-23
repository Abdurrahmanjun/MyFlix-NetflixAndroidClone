package com.abdurrahmanjun.splashscreen.di

import com.abdurrahmanjun.core.base.FeatureModules
import com.abdurrahmanjun.shared.data.remote.NetworkClient
import com.abdurrahmanjun.splashscreen.data.network.datasource.SplashScreenDataSource
import com.abdurrahmanjun.splashscreen.data.network.datasource.SplashScreenDataSourceImpl
import com.abdurrahmanjun.splashscreen.data.network.service.SplashScreenFeatureApi
import com.abdurrahmanjun.splashscreen.data.repository.SplashScreenRepository
import com.abdurrahmanjun.splashscreen.data.repository.SplashScreenRepositoryImpl
import com.abdurrahmanjun.splashscreen.domain.SyncUserUseCase
import com.abdurrahmanjun.splashscreen.presentation.ui.SplashScreenViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object SplashScreenModules : FeatureModules {
    override fun getModules(): List<Module> = listOf(
        repositories, viewModels, dataSources, useCases, network
    )

    override val repositories: Module = module {
        single<SplashScreenRepository> { SplashScreenRepositoryImpl(get()) }
    }

    override val viewModels: Module = module {
        viewModelOf(::SplashScreenViewModel)
    }

    override val dataSources: Module = module {
        single<SplashScreenDataSource> { SplashScreenDataSourceImpl(get()) }
    }

    override val useCases: Module = module {
        single { SyncUserUseCase(get(), get(), Dispatchers.IO) }
    }

    override val network: Module = module {
        single<SplashScreenFeatureApi> { get<NetworkClient>().create() }
    }
}