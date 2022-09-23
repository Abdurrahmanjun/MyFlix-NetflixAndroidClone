package com.abdurrahmanjun.home.data.network.model.response

import com.abdurrahmanjun.shared.data.model.response.MovieResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class HomeFeedsResponse(
    @SerializedName("header")
    val header: MovieResponse?,
    @SerializedName("sections")
    val sections: List<SectionResponse>?,
)
