package com.alex.ui.mainflow.login

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alex.data.network.ApiService
import com.alex.data.repository.ResourcesRepository
import com.alex.data.repository.ServerApiRepository
import com.alex.getOrAwaitValue
import com.alex.getTestSchedulerProvider
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class LoginViewModelIntegrTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `should return error message when do login with empty email`() {

        // before
        val scheduler = getTestSchedulerProvider()
        val context: Context = ApplicationProvider.getApplicationContext()
        val resourcesRepository = ResourcesRepository(context)
        val interactor = LoginInteractor(ServerApiRepository(ApiService()), resourcesRepository)
        val viewModel = LoginViewModel(interactor, scheduler)

        // when do `log in`
        viewModel.login("", "11111111")

        // then return error message
        assertEquals(resourcesRepository.getInvalidEmailStr(), viewModel.error.getOrAwaitValue())
    }
}