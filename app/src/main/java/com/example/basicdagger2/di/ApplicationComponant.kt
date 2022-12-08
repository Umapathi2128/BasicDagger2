package com.example.basicdagger2.di

import android.content.Context
import com.example.basicdagger2.ui.adapters.ProductListAdapter
import com.example.basicdagger2.ui.detail.DetailActivity
import com.example.basicdagger2.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivitiesModules::class,NetworkModule::class])
interface ApplicationComponant {

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)


    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponant
    }
}