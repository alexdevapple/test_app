package com.alex.di.modules

import com.alex.data.network.ApiService
import dagger.Module
import dagger.Provides

@Module
class ApiServiceModule {

    @Provides
    fun bindApiService() = ApiService()
}