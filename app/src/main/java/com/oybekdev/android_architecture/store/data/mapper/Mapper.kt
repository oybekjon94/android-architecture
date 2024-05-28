package com.oybekdev.android_architecture.store.data.mapper

import com.oybekdev.android_architecture.store.domain.model.ApiError
import com.oybekdev.android_architecture.store.domain.model.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toGeneralError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}