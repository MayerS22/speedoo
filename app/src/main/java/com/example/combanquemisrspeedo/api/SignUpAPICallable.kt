package com.example.combanquemisrspeedo.api

import com.example.combanquemisrspeedo.model.signUpData.RegisterRequestDTO
import com.example.combanquemisrspeedo.model.signUpData.RegisterResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpAPICallable {
    @POST("/api/auth/register")
    suspend fun signUp(@Body request: RegisterRequestDTO): Response<RegisterResponseDTO>
}