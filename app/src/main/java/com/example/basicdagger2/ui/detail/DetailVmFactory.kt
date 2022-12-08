package com.example.basicdagger2.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicdagger2.repository.DataManager
import javax.inject.Inject

class DetailVmFactory @Inject constructor(private val dataManager: DataManager) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(dataManager) as T
    }


}