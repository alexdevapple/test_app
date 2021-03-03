package com.alex.di.modules

import com.alex.ui.mainflow.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector(modules = [ApiServiceModule::class])
    abstract fun contributeHomeFragment(): LoginFragment
}