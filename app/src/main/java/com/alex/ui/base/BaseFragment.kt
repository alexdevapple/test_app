package com.alex.ui.base

import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

open class BaseFragment(@LayoutRes layoutId: Int) : DaggerFragment(layoutId)