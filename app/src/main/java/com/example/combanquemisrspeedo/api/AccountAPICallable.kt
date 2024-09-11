package com.example.combanquemisrspeedo.api

import com.example.combanquemisrspeedo.model.userDato.AccountDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AccountAPICallable {

    @GET("/api/account/{accountId}")
    suspend fun getAccountById(@Path("accountId") accountId: Long): AccountDTO

    @POST("/api/account")
    suspend fun createAccount(@Body accountDTO: AccountDTO): AccountDTO
}

