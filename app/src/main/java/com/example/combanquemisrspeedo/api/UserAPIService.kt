package com.example.combanquemisrspeedo.api

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://3.70.134.143/api/v1/" // Replace with your actual base URL

object UserAPIService {

    private fun okhttpClient(token: String? = null): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()

            token?.let {
                Log.d("TAG", "okhttpClient: $token")
                newRequest.addHeader("Authorization", "Bearer $it")
            }

            chain.proceed(newRequest.build())
        }.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Base URL of your API
//            .client(okhttpClient(token = TokenStorage.getToken(AppContextProvider.context)))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userAPI: UserAPICallable by lazy {
        retrofit.create(UserAPICallable::class.java)
    }
}
