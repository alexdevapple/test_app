package com.alex.data.repository

import android.content.Context
import com.alex.R
import javax.inject.Inject

class ResourcesRepository @Inject constructor(private val context: Context) {
    fun getInvalidEmailStr(): String = context.getString(R.string.text_error_invalid_email)
    fun getInvalidPasswordStr(): String = context.getString(R.string.text_error_invalid_password)
    fun getLoginSuccessStr(): String = context.getString(R.string.text_logged_in_successfully)
    fun getInternalServerErrorStr(): String = context.getString(R.string.text_error_internal_server_error)
    fun getUnknownErrorStr(): String = context.getString(R.string.text_error_unknown_error)
    fun getWrongCredentialsStr(): String = context.getString(R.string.text_error_wrong_credentials)
    fun getSomethingWentWrongStr(): String = context.getString(R.string.text_error_something_went_wrong)
}