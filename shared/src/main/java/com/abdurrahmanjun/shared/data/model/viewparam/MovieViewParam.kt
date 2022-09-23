package com.abdurrahmanjun.shared.data.model.viewparam

/**
 * Created by AbdurrahmanJun on 11,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
data class MovieViewParam(
    val cast: List<String>,
    val category: List<String>,
    val director: String,
    val filmRate: String,
    val id: Int,
    var isUserWatchlist: Boolean,
    val overview: String,
    val posterUrl: String,
    val releaseDate: String,
    val runtime: Int,
    val title: String,
    val trailerUrl: String,
    val videoUrl: String
)