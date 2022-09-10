package com.abdurrahmanjun.core.exception

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class ApiErrorException(
    override val message: String? = null,
    val httpCode: Int? = null
) : Exception()