package com.example.combanquemisrspeedo.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignUpAPIService {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://speedo-production.up.railway.app/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable: SignUpAPICallable by lazy {
        retrofit.create(SignUpAPICallable::class.java)
    }
}