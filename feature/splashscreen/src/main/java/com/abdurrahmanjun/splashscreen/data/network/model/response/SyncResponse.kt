package com.abdurrahmanjun.splashscreen.data.network.model.response

import com.abdurrahmanjun.shared.data.model.response.UserResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class SyncResponse(
    @SerializedName("user")
    val userResponse: UserResponse?
)
