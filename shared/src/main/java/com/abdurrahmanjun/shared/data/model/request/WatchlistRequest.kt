package com.abdurrahmanjun.shared.data.model.request

import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class WatchlistRequest(
    @SerializedName("movie_id")
    val movieId: String,
)
