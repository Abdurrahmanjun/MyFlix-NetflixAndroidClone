package com.abdurrahmanjun.core.utlis

import android.content.Context
import com.abdurrahmanjun.core.exception.ApiErrorException
import com.abdurrahmanjun.core.exception.NoInternetConnectionException

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
fun Context.getErrorMessage(exception : Exception): String {
    return when (exception) {
        is NoInternetConnectionException -> getString(com.abdurrahmanjun.styling.R.string.message_error_no_internet)
        is ApiErrorException -> exception.message.orEmpty()
        else -> getString(com.abdurrahmanjun.styling.R.string.message_error_unknown)
    }
}