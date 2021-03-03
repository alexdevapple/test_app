package com.alex.ui.mainflow.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alex.getOrAwaitValue
import com.alex.getTestSchedulerProvider
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class LoginViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `should change error state when email is empty`() {
        // before
        val schedulers = getTestSchedulerProvider()
        val errorMessage = "Wrong email"
        val interactor: LoginInteractor = mockk(relaxed = true)
        every {
            interactor.login(any(), any())
        } returns Single.fromCallable { LoginInteractor.LoginResponse(false, errorMessage) }
        val viewModel = LoginViewModel(interactor, schedulers)

        // when do log in
        viewModel.login("", "")

        // then `error` state must be changed
        assertEquals(errorMessage, viewModel.error.getOrAwaitValue())
    }
}