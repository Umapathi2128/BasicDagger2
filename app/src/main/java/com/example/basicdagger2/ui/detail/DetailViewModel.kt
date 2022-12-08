package com.example.basicdagger2.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicdagger2.repository.DataManager
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val dataManager: DataManager): ViewModel() {


    var eTitle  = MutableLiveData<String>()
    var eDescription  = MutableLiveData<String>()
    var eRatting  = MutableLiveData<Float>()
    var eImage  = MutableLiveData<String>()
    var ePrice  = MutableLiveData<String>()

}