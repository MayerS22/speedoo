package com.example.combanquemisrspeedo.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object LoginAPIService {
    //"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmdAc3QiLCJpYXQiOjE3MjU5OTI3MzMsImV4cCI6MTcyNTk5NDUzM30.ErbQPuRNCkWDubqvzizCT6foyVKXS6xsZvsO1wopdr4"

    val intercepter = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    private fun okhttpClient(token: String? = null): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()

            token?.let {
                newRequest.addHeader("Authorization", "Bearer $it")
            }

            chain.proceed(newRequest.build())
        }.build()
    }

    val client = OkHttpClient.Builder().apply {
        this.addInterceptor(intercepter)
            // time out setting
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(25,TimeUnit.SECONDS)

    }.build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://speedo-production.up.railway.app/api/") // Replace with your actual base URL
//         .client(okhttpClient(token = TokenStorage.getToken(AppContextProvider.context))) // Pass token here if needed
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginAPI: UserAPICallable by lazy {
        retrofit.create(UserAPICallable::class.java)
    }
}
