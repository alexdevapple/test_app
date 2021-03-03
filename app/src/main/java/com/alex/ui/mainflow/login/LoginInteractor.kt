package com.alex.ui.mainflow.login

import com.alex.data.network.Error
import com.alex.data.repository.ResourcesRepository
import com.alex.data.repository.ServerApiRepository
import com.alex.data.repository.ServerApiRepository.Response
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginInteractor @Inject constructor(
    private val apiRepository: ServerApiRepository,
    private val resourcesRepository: ResourcesRepository
) {

    data class LoginResponse(val success: Boolean, val message: String)

    fun login(email: String, password: String): Single<LoginResponse> {
        return Single.create {
            when {
                email.isEmpty() -> it.onError(IllegalArgumentException(resourcesRepository.getInvalidEmailStr()))
                password.isEmpty() -> it.onError(IllegalArgumentException(resourcesRepository.getInvalidPasswordStr()))
                else -> {
                    try {
                        val response = apiRepository.login(email = email, password = password)
                        val result = handleLoginResponse(response)
                        it.onSuccess(result)
                    } catch (e: IllegalStateException) {
                        e.printStackTrace()
                        it.onError(IllegalStateException(resourcesRepository.getSomethingWentWrongStr()))
                    }
                }
            }
        }
    }

    internal fun handleLoginResponse(response: Response<Int>): LoginResponse {
        return when (response) {
            is Response.Success<Int> -> {
                LoginResponse(true, resourcesRepository.getLoginSuccessStr())
            }
            is Response.Failure -> {
                val errorStr = convertErrorToDescr(response.error)
                LoginResponse(false, errorStr)
            }
        }
    }

    private fun convertErrorToDescr(error: Error): String {
        return when (error) {
            Error.WRONG_CREDENTIALS -> resourcesRepository.getWrongCredentialsStr()
            Error.INTERNAL_SERVER_ERROR -> resourcesRepository.getInternalServerErrorStr()
            Error.UNKNOWN_ERROR -> resourcesRepository.getUnknownErrorStr()
        }
    }
}