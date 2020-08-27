package com.demo.androiddemo

import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET(".")
    fun fetchData(): Call<DataBean?>?
}