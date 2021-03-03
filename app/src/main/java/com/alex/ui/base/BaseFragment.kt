package com.alex.ui.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

open class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId)