package com.example.basicdagger2.repository

import com.example.basicdagger2.network.ApiService
import javax.inject.Inject

class DataManager @Inject constructor (val apiService: ApiService) : DataHelper {


    suspend fun getProductDetails() =
        apiService.getProductDetailApi()
}