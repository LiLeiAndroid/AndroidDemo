package com.demo.androiddemo

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author FrankWang
 * @time 2020/8/27 11:36 AM
 */
class DataRepositoryImpl : DataRepository {

    private var data: DataBean? = DataBean("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")

    override fun loadData(): DataBean? {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 设置参数
        val call: Call<DataBean?>? = retrofit.create(DataService::class.java)
            .fetchData()

        // 回调
        call?.enqueue(object : Callback<DataBean?> {
            override fun onResponse(call: Call<DataBean?>?, response: Response<DataBean?>) {
                Log.d("Data",response.body().toString())
                data = response.body()
            }

            override fun onFailure(call: Call<DataBean?>?, t: Throwable?) {
                // 失败时做处理
                Log.d("Data","请求失败")
                data = DataBean("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")
            }
        })
        return data
    }
}