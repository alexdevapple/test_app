package com.alex

import com.alex.data.providers.SchedulersProvider
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.schedulers.TestScheduler

fun getTestSchedulerProvider(): SchedulersProvider {
    val scheduler = TestScheduler()
    return mockk {
        every { getIoScheduler() } returns scheduler
        every { getMainScheduler() } returns scheduler
    }
}