package com.example.basicdagger2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicdagger2.model.ProductDataModel
import com.example.basicdagger2.repository.DataManager
import com.example.basicdagger2.utils.NetworkHelper
import com.example.basicdagger2.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val dataManager: DataManager,
    val networkHelper: NetworkHelper
) : ViewModel() {


    private val _products: MutableLiveData<Resource<ProductDataModel>> = MutableLiveData()

    val products: LiveData<Resource<ProductDataModel>>
        get() = _products

//    private val _products : MutableLiveData<DummyModel> = MutableLiveData()
//
//    val products: LiveData<DummyModel>
//        get() = _products

    init {
        getProductDetails()
    }

    private fun getProductDetails() {
        viewModelScope.launch {
            _products.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                val results = dataManager.getProductDetails()
                if (results.isSuccessful)
                    _products.postValue(Resource.success(results.body()))
                else _products.postValue(Resource.error("Something went wrong", null))
            }else{
                _products.postValue(Resource.error("No Internet",null))
            }
        }
    }

}