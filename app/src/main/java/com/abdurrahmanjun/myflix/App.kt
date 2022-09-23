package com.abdurrahmanjun.myflix

import android.app.Application
import com.abdurrahmanjun.login.di.LoginModules
import com.abdurrahmanjun.myflix.di.AppModules
import com.abdurrahmanjun.register.di.RegisterModules
import com.abdurrahmanjun.shared.di.SharedModules
import com.abdurrahmanjun.splashscreen.di.SplashScreenModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                AppModules.getModules() +
                        SharedModules.getModules() +
                        SplashScreenModules.getModules() +
                        LoginModules.getModules() +
                        RegisterModules.getModules() +
                        HomeModules.getModules()
            )
        }

    }
}