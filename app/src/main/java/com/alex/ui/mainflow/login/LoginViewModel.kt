package com.alex.ui.mainflow.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.data.providers.SchedulersProvider
import com.alex.ui.base.BaseViewModel
import com.alex.utils.defaultSchedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val interactor: LoginInteractor,
    private val schedulersProvider: SchedulersProvider
) : BaseViewModel() {

    val isLoading: LiveData<Boolean> get() = _isLoading
    val error: LiveData<String> get() = _error
    val result: LiveData<String> get() = _result

    private val _isLoading = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()
    private val _result = MutableLiveData<String>()

    fun login(email: String, password: String) {
        _isLoading.value = true
        interactor.login(email, password)
            .defaultSchedulers(schedulersProvider)
            .doFinally { _isLoading.postValue(false) }
            .subscribe({
                if (it.success) {
                    _result.postValue(it.message)
                } else {
                    _error.postValue(it.message)
                }
            }, {
                it.printStackTrace()
                _error.postValue(it.message)
            }).connectToSubscriptions()
    }
}