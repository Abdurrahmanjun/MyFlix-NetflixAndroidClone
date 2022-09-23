package com.abdurrahmanjun.register.di

import com.abdurrahmanjun.core.base.FeatureModules
import com.abdurrahmanjun.register.data.network.datasource.RegisterDataSource
import com.abdurrahmanjun.register.data.network.datasource.RegisterDataSourceImpl
import com.abdurrahmanjun.register.data.network.services.RegisterFeatureApi
import com.abdurrahmanjun.register.data.repository.RegisterRepository
import com.abdurrahmanjun.register.data.repository.RegisterRepositoryImpl
import com.abdurrahmanjun.register.domain.CheckRegisterFieldUseCase
import com.abdurrahmanjun.register.domain.RegisterUserUseCase
import com.abdurrahmanjun.register.presentation.ui.RegisterViewModel
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
object RegisterModules : FeatureModules {
    override fun getModules(): List<Module> =
        listOf(repositories, viewModels, dataSources, useCases, network)

    override val repositories: Module = module {
        single<RegisterRepository> { RegisterRepositoryImpl(get()) }
    }

    override val viewModels: Module = module {
        viewModelOf(::RegisterViewModel)
    }

    override val dataSources: Module = module {
        single<RegisterDataSource> { RegisterDataSourceImpl(get()) }
    }

    override val useCases: Module = module {
        single { CheckRegisterFieldUseCase(Dispatchers.IO) }
        single { RegisterUserUseCase(get(), get(), get(), Dispatchers.IO) }
    }

    override val network: Module = module {
        single<RegisterFeatureApi> { get<NetworkClient>().create() }
    }
}