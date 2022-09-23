package com.abdurrahmanjun.home.presentation.viewparam.homeitem

import com.abdurrahmanjun.home.presentation.viewparam.SectionViewParam
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
sealed class HomeUiItem{
    class HeaderSectionItem(val movieViewParam: MovieViewParam) : HomeUiItem()
    class MovieSectionItem(val sectionViewParam: SectionViewParam) : HomeUiItem()
}
