package com.example.combanquemisrspeedo.api

import android.content.Context
import com.example.combanquemisrspeedo.model.TokenStorage
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AccountAPIService {
    private val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    fun getClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                val token = TokenStorage.getToken(context) // Get the token from TokenStorage
                if (token != null) {
                    requestBuilder.addHeader("Authorization", "Bearer $token")
                }
                chain.proceed(requestBuilder.build())
            }
            this.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
    }

    fun getRetrofit(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://speedo-production.up.railway.app/") // Ensure this is your actual base URL
            .client(getClient(context)) // Pass the OkHttpClient with the token
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getAccountAPI(context: Context): AccountAPICallable {
        return getRetrofit(context).create(AccountAPICallable::class.java)
    }
}

