package com.alex

import android.app.Activity
import com.alex.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AlexApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)

        return appComponent
    }

    companion object {
        fun get(activity: Activity): AlexApplication {
            return activity.application as AlexApplication
        }
    }
}