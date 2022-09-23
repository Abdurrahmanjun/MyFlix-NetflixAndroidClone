package com.abdurrahmanjun.shared.data.model.mapper

import com.abdurrahmanjun.shared.data.model.response.UserResponse
import com.abdurrahmanjun.shared.data.model.viewparam.UserViewParam
import com.abdurrahmanjun.shared.utils.mapper.ViewParamMapper

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object UserMapper : ViewParamMapper<UserResponse, UserViewParam> {
    override fun toViewParam(dataObject: UserResponse?): UserViewParam = UserViewParam(
        email = dataObject?.email.orEmpty(),
        birthdate = dataObject?.birthdate.orEmpty(),
        gender = dataObject?.gender ?: -1,
        id = dataObject?.id ?: -1,
        username = dataObject?.username.orEmpty()
    )
}