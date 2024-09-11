package com.example.combanquemisrspeedo.api

import android.content.Context
import com.example.combanquemisrspeedo.model.TokenStorage
import com.example.combanquemisrspeedo.model.TokenStoragee
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object UserAPIService {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun createService(): UserAPICallable {
        return Retrofit.Builder()
            .baseUrl("https://speedo-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val originalRequest = chain.request()
                        val token = TokenStoragee.getToken() ?: ""
                        val newRequest = originalRequest.newBuilder()
                            .header("Authorization", "Bearer $token")
                            .build()
                        chain.proceed(newRequest)
                    }
                    .addInterceptor(interceptor)
                    .build()
            )
            .build()
            .create(UserAPICallable::class.java)
    }
}

