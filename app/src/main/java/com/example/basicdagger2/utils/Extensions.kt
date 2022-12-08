package com.example.basicdagger2.utils

import android.view.View

fun View.isShow(show: Boolean) {
    if (show)
        visibility = View.VISIBLE
    else visibility = View.GONE
}