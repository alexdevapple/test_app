package com.alex.data.providers

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SchedulersProvider @Inject constructor() {
    fun getIoScheduler(): Scheduler = Schedulers.io()
    fun getMainScheduler(): Scheduler = AndroidSchedulers.mainThread()
}