package com.abdurrahmanjun.myflix.router

import android.content.Context
import android.content.Intent
import com.abdurrahmanjun.home.presentation.ui.home.HomeActivity
import com.abdurrahmanjun.login.presentation.ui.LoginActivity
import com.abdurrahmanjun.register.presentation.ui.RegisterActivity
import com.abdurrahmanjun.shared.router.ActivityRouter

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class ActivityRouterImpl : ActivityRouter {
    override fun loginActivity(context: Context): Intent {
        return Intent(context, LoginActivity::class.java)
    }

    override fun homeActivity(context: Context): Intent {
        return Intent(context, HomeActivity::class.java)
    }

    override fun registerActivity(context: Context): Intent {
        return Intent(context, RegisterActivity::class.java)
    }
}