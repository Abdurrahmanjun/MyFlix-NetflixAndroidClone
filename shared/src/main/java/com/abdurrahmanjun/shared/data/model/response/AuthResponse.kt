package com.abdurrahmanjun.shared.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class AuthResponse(
    @SerializedName("token")
    val token: String?,
    @SerializedName("token_type")
    val tokenType: String?,
    @SerializedName("user")
    val user: UserResponse?
)
