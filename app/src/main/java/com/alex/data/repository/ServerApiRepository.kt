package com.alex.data.repository

import com.alex.data.network.ApiService
import com.alex.data.network.Error
import com.alex.data.repository.ApiResponseModelAdapter.adapt
import javax.inject.Inject

class ServerApiRepository @Inject constructor(private val apiService: ApiService) {

    sealed class Response<out T> {
        data class Success<out T>(val value: T) : Response<T>()
        data class Failure(val error: Error) : Response<Nothing>()
    }

    @Throws(exceptionClasses = [IllegalStateException::class])
    fun login(email: String, password: String): Response<Int> {
        val response = apiService.login(email, password)
        return adapt(response)
    }
}