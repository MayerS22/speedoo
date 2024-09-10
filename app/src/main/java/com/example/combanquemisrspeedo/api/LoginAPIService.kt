package com.example.combanquemisrspeedo.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginAPIService {

    private fun okhttpClient(token: String? = null): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()

            token?.let {
                newRequest.addHeader("Authorization", "Bearer $it")
            }

            chain.proceed(newRequest.build())
        }.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://3.70.134.143") // Replace with your actual base URL
//            .client(okhttpClient(token = TokenStorage.getToken(AppContextProvider.context))) // Pass token here if needed
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginAPI: UserAPICallable by lazy {
        retrofit.create(UserAPICallable::class.java)
    }
}
