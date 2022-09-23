package com.abdurrahmanjun.home.presentation.viewparam

import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class SectionViewParam(
    @SerializedName("section_id")
    val sectionId: Int,
    @SerializedName("section_name")
    val sectionName: String,
    @SerializedName("contents")
    val contents: List<MovieViewParam>,
)
