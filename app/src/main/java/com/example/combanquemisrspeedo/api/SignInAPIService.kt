package com.example.combanquemisrspeedo.api

import android.content.Context
import com.example.combanquemisrspeedo.api.SignInAPIService.userAPI
import com.example.combanquemisrspeedo.model.TokenStorage
import com.example.combanquemisrspeedo.model.signInData.SignInRequest
import com.example.combanquemisrspeedo.model.signInData.SignInResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object SignInAPIService {
    private val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://speedo-production.up.railway.app/") // Ensure this is your actual base URL
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userAPI: SignInAPICallable by lazy {
        retrofit.create(SignInAPICallable::class.java)
    }
}

