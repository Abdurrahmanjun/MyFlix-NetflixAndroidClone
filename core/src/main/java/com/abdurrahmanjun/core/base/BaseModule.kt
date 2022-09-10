package com.abdurrahmanjun.core.base

import org.koin.core.module.Module

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface BaseModules {
    fun getModules() : List<Module>
}

interface FeatureModules : BaseModules{
    val repositories : Module
    val viewModels : Module
    val dataSources : Module
    val useCases : Module
    val network : Module
}