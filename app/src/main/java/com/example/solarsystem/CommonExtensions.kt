package com.example.solarsystem

import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
}