package com.alex.ui.base

import androidx.annotation.LayoutRes
import com.alex.data.providers.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

open class BaseFragment(@LayoutRes layoutId: Int) : DaggerFragment(layoutId){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}