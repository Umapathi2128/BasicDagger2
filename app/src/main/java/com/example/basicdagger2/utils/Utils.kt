package com.example.basicdagger2.utils

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

object Utils {

//    fun providesApplication() : MyApplication = application
//
//    fun getContext() : Context = application

    fun getImagePlaceHolderLoading(context: Context): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        return circularProgressDrawable
    }

}