package com.abdurrahmanjun.login.di

import com.abdurrahmanjun.core.base.FeatureModules
import com.abdurrahmanjun.login.data.network.datasource.LoginDataSource
import com.abdurrahmanjun.login.data.network.datasource.LoginDataSourceImpl
import com.abdurrahmanjun.login.data.network.service.LoginFeatureApi
import com.abdurrahmanjun.login.data.repository.LoginRepository
import com.abdurrahmanjun.login.data.repository.LoginRepositoryImpl
import com.abdurrahmanjun.login.domain.CheckLoginFieldUseCase
import com.abdurrahmanjun.login.domain.LoginUserUseCase
import com.abdurrahmanjun.login.presentation.ui.LoginViewModel
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
object LoginModules : FeatureModules {

    override fun getModules(): List<Module> = listOf(repositories, viewModels, dataSources, useCases, network)

    override val repositories: Module = module {
        single<LoginRepository> { LoginRepositoryImpl(get()) }
    }

    override val viewModels: Module = module {
        viewModelOf(::LoginViewModel)
    }

    override val dataSources: Module = module {
        single<LoginDataSource> { LoginDataSourceImpl(get()) }
    }

    override val useCases: Module = module {
        single { CheckLoginFieldUseCase(Dispatchers.IO) }
        single { LoginUserUseCase(get(), get(), get(), Dispatchers.IO) }
    }

    override val network: Module = module {
        single<LoginFeatureApi> { get<NetworkClient>().create() }
    }

}