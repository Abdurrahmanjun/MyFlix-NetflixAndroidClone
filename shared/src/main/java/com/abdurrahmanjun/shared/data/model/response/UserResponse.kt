package com.abdurrahmanjun.shared.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class UserResponse(
    @SerializedName("birthdate")
    val birthdate: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("username")
    val username: String?
)