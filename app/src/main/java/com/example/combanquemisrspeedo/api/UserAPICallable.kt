package com.example.combanquemisrspeedo.api

import com.example.combanquemisrspeedo.model.userDato.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserAPICallable {
    @GET("api/user/{userId}")
    suspend fun getUserById(
        @Path("userId") userId: Long
    ): Response<UserDTO>
}




