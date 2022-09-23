package com.abdurrahmanjun.shared.data.repository

import com.abdurrahmanjun.core.base.BaseRepository
import com.abdurrahmanjun.shared.data.model.response.BaseResponse
import com.google.gson.Gson
import com.google.gson.JsonParseException
import okhttp3.ResponseBody
import org.koin.java.KoinJavaComponent

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
open class Repository : BaseRepository() {
    private val gson: Gson by KoinJavaComponent.inject(Gson::class.java)

    override fun <T> getErrorMessageFromApi(response: T): String {
        val responseBody = response as ResponseBody
        return try {
            val body = gson.fromJson(responseBody.string(), BaseResponse::class.java)
            body.message ?: "Error Api"
        } catch (e: JsonParseException) {
            "Error Api"
        }

    }
}