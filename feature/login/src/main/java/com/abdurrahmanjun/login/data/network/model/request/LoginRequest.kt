package com.abdurrahmanjun.login.data.network.model.request

import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class LoginRequest(
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?
)
