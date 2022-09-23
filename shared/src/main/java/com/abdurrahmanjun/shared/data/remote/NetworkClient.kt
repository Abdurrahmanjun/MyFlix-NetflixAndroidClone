package com.abdurrahmanjun.shared.data.remote

import com.abdurrahmanjun.core.BuildConfig
import com.abdurrahmanjun.shared.domain.GetUserTokenUseCase
import com.chuckerteam.chucker.api.ChuckerInterceptor
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class NetworkClient(
    val getUserTokenUseCase: GetUserTokenUseCase,
    val chuckerInterceptor: ChuckerInterceptor
) {

    inline fun <reified I> create(): I {
        val authInterceptor = Interceptor {
            val requestBuilder = it.request().newBuilder()
            runBlocking {
                getUserTokenUseCase().first { tokenResponse ->
                    val token = tokenResponse.payload
                    if (!token.isNullOrEmpty()) {
                        requestBuilder.addHeader("Authorization", "Bearer $token")
                    }
                    true
                }
            }
            it.proceed(requestBuilder.build())
        }
        //okhttp
        val okhttpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(chuckerInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()

        return retrofit.create(I::class.java)
    }
}