package com.alex.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.makeSnackbar(message: String): Snackbar {
    return Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
}