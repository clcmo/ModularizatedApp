package com.clcmo.data.extensions

import retrofit2.HttpException

fun Throwable.mapRemoteErrors(): ResultRemote.ErrorResponse = when (this) {
    is HttpException -> {
        when (code()) {
            401, 403 -> ResultRemote.ErrorResponse.TokenExpired(this)
            else -> ResultRemote.ErrorResponse.Unknown(this)
        }
    }
    else -> ResultRemote.ErrorResponse.Unknown(this)
}