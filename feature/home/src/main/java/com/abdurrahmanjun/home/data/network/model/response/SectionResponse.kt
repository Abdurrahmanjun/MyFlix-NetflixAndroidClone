package com.abdurrahmanjun.home.data.network.model.response

import com.abdurrahmanjun.shared.data.model.response.MovieResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class SectionResponse(
    @SerializedName("section_id")
    val sectionId: Int?,
    @SerializedName("section_name")
    val sectionName: String?,
    @SerializedName("contents")
    val contents: List<MovieResponse>?,
)
