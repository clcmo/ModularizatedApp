package com.clcmo.modularizatedapp.extensions

import android.view.View

fun View.visible(visible: Boolean = false) {
    visibility = when {
        visible -> View.VISIBLE
        else -> View.GONE
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}