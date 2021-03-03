package com.alex.data.repository

import com.alex.data.network.ApiResponse

object ApiResponseModelAdapter {
    fun <T> adapt(response: ApiResponse<T?>): ServerApiRepository.Response<T> {
        if (response.result != null) return ServerApiRepository.Response.Success(response.result)
        if (response.error != null) return ServerApiRepository.Response.Failure(response.error)
        else throw IllegalStateException("Can't handle response")
    }
}