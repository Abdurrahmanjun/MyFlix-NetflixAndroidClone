package com.abdurrahmanjun.myflix.di

import com.abdurrahmanjun.core.base.BaseModules
import com.abdurrahmanjun.myflix.router.ActivityRouterImpl
import com.abdurrahmanjun.shared.router.ActivityRouter
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object AppModules : BaseModules {
    override fun getModules(): List<Module> = listOf(routers)

    val routers: Module = module {
        single<ActivityRouter> { ActivityRouterImpl() }
    }
}