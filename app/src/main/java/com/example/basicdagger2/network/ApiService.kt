package com.example.basicdagger2.network

import com.example.basicdagger2.model.DummyModel
import com.example.basicdagger2.model.ProductDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProductDetailApi() : Response<ProductDataModel>

    @GET("todos/1")
    suspend fun getProductDetailApi1() : Response<DummyModel>
}