package com.example.testretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://v.api.aa1.cn/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}