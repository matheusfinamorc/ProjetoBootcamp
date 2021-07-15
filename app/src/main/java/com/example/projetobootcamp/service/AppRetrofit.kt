package com.example.projetobootcamp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://www.freetogame.com/"

class AppRetrofit {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val jogosService: API by lazy {
        retrofit.create(API::class.java)
    }

}