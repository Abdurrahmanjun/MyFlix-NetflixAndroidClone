package com.abdurrahmanjun.shared.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class BaseResponse<D>(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("success")
    val isSuccess: Boolean?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: D?,
)
