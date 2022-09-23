package com.abdurrahmanjun.home.presentation.viewparam

import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.google.gson.annotations.SerializedName

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class HomeFeedsViewParam(
    @SerializedName("header")
    val header: MovieViewParam,
    @SerializedName("sections")
    val sections: List<SectionViewParam>,
)
