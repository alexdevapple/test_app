package com.alex.di

import android.app.Application
import com.alex.AlexApplication
import com.alex.di.modules.ActivityModule
import com.alex.di.modules.AppModule
import com.alex.di.modules.FragmentsModule
import com.alex.di.modules.PresentationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentsModule::class,
        AppModule::class,
        PresentationModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AlexApplication)
}