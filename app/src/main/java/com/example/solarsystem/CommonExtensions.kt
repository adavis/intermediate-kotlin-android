package com.example.solarsystem

import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View

/**
 * @author Annyce Davis
 */
fun View.showSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
}

inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply{
        action()
    }.commit()
}