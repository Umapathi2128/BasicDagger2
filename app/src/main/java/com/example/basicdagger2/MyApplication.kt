package com.example.basicdagger2

import android.app.Application
import com.example.basicdagger2.di.ApplicationComponant
import com.example.basicdagger2.di.DaggerApplicationComponant
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication() : Application(),HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponant: ApplicationComponant

    override fun androidInjector(): AndroidInjector<Any> = activityInjector

    override fun onCreate() {
        super.onCreate()
        appComponant = DaggerApplicationComponant.factory().create(this)
    }
}