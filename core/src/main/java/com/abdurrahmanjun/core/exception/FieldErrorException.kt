package com.abdurrahmanjun.core.exception

/**
 * Created by AbdurrahmanJun on 24,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class FieldErrorException(val errorFields: List<Pair<Int, Int>>) : Exception()