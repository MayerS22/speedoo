package com.example.combanquemisrspeedo.api

import com.example.combanquemisrspeedo.model.signInData.SignInRequest
import com.example.combanquemisrspeedo.model.signInData.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInAPICallable {
        @POST("api/auth/login")
        suspend fun signIn(@Body request: SignInRequest): Response<SignInResponse>
}