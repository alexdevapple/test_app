package com.alex.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val subscriptions = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }

    protected fun Disposable.connectToSubscriptions(): Disposable {
        subscriptions.add(this)
        return this
    }
}