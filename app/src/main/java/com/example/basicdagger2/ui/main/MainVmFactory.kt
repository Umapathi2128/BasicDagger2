package com.example.basicdagger2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicdagger2.repository.DataManager
import com.example.basicdagger2.utils.NetworkHelper
import javax.inject.Inject

class MainVmFactory @Inject constructor(private val dataManager: DataManager,private val networkHelper: NetworkHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(dataManager,networkHelper) as T
    }

}