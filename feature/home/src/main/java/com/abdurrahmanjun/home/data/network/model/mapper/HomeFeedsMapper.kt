package com.abdurrahmanjun.home.data.network.model.mapper

import com.abdurrahmanjun.home.data.network.model.response.HomeFeedsResponse
import com.abdurrahmanjun.home.data.network.model.response.SectionResponse
import com.abdurrahmanjun.home.presentation.viewparam.HomeFeedsViewParam
import com.abdurrahmanjun.home.presentation.viewparam.SectionViewParam
import com.abdurrahmanjun.shared.data.model.mapper.MovieMapper
import com.abdurrahmanjun.shared.utils.mapper.ListMapper
import com.abdurrahmanjun.shared.utils.mapper.ViewParamMapper

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object HomeFeedsMapper : ViewParamMapper<HomeFeedsResponse, HomeFeedsViewParam> {
    override fun toViewParam(dataObject: HomeFeedsResponse?): HomeFeedsViewParam = HomeFeedsViewParam(
        MovieMapper.toViewParam(dataObject?.header),
        ListMapper(SectionMapper).toViewParams(dataObject?.sections)
    )
}

object SectionMapper : ViewParamMapper<SectionResponse, SectionViewParam>{
    override fun toViewParam(dataObject: SectionResponse?): SectionViewParam = SectionViewParam(
        sectionId =  dataObject?.sectionId ?: -1,
        sectionName = dataObject?.sectionName.orEmpty(),
        contents = ListMapper(MovieMapper).toViewParams(dataObject?.contents)
    )
}