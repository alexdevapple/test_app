package com.alex.utils

import com.alex.data.providers.SchedulersProvider
import io.reactivex.rxjava3.core.Single

fun <T> Single<T>.defaultSchedulers(schedulersProvider: SchedulersProvider): Single<T> {
    subscribeOn(schedulersProvider.getMainScheduler())
    observeOn(schedulersProvider.getIoScheduler())
    return this
}