package com.abdurrahmanjun.register.data.network.model.request

import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class RegisterRequest(
    @SerializedName("birthdate")
    val birthdate: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("username")
    val username: String?
    )
