package com.alex.data.network


// Represents a possible HTTP error
enum class Error {
    WRONG_CREDENTIALS,
    INTERNAL_SERVER_ERROR,
    UNKNOWN_ERROR
}

// Represents a response from the API
data class ApiResponse<T>(
    val result: T?,
    val error: Error?
)

// This class and method will simulate the login endpoint
class ApiService {
    fun login(username: String, password: String): ApiResponse<Int?> {
        return when (username) {
            "user" -> {
                ApiResponse(
                    result = 1,
                    error = null
                )
            }
            "wrong" -> {
                ApiResponse(
                    result = null,
                    error = Error.WRONG_CREDENTIALS
                )
            }
            "internal" -> {
                ApiResponse(
                    result = null,
                    error = Error.INTERNAL_SERVER_ERROR
                )
            }
            else -> {
                ApiResponse(
                    result = null,
                    error = Error.UNKNOWN_ERROR
                )
            }
        }
    }
}