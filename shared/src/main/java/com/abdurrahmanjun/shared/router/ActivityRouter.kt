package com.abdurrahmanjun.shared.router

import android.content.Context
import android.content.Intent

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
interface ActivityRouter {
    fun loginActivity(context: Context): Intent
    fun homeActivity(context: Context): Intent
    fun registerActivity(context: Context): Intent
}