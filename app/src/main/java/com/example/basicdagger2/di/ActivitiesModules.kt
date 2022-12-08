package com.example.basicdagger2.di

import com.example.basicdagger2.model.ProductItem
import com.example.basicdagger2.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivitiesModules {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity



}