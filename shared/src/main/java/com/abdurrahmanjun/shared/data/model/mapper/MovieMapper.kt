package com.abdurrahmanjun.shared.data.model.mapper

import com.abdurrahmanjun.shared.data.model.response.MovieResponse
import com.abdurrahmanjun.shared.data.model.viewparam.MovieViewParam
import com.abdurrahmanjun.shared.utils.mapper.ViewParamMapper

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
object MovieMapper : ViewParamMapper<MovieResponse, MovieViewParam> {
    override fun toViewParam(dataObject: MovieResponse?): MovieViewParam = MovieViewParam(
        cast = dataObject?.cast.orEmpty(),
        category = dataObject?.category.orEmpty(),
        director = dataObject?.director.orEmpty(),
        filmRate = dataObject?.filmRate.orEmpty(),
        id = dataObject?.id ?: -1,
        isUserWatchlist = dataObject?.isUserWatchlist ?: false,
        overview = dataObject?.overview.orEmpty(),
        posterUrl = dataObject?.posterUrl.orEmpty(),
        releaseDate = dataObject?.releaseDate.orEmpty(),
        title = dataObject?.title.orEmpty(),
        trailerUrl = dataObject?.trailerUrl.orEmpty(),
        videoUrl = dataObject?.videoUrl.orEmpty(),
        runtime = dataObject?.runtime ?: -1,
    )
}