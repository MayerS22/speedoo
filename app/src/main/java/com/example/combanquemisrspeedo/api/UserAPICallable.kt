package com.example.combanquemisrspeedo.api

import com.example.combanquemisrspeedo.model.AccountDTO
import com.example.combanquemisrspeedo.model.AddAccountRequest
import com.example.combanquemisrspeedo.model.AddFavoriteRequest
import com.example.combanquemisrspeedo.model.ChangeDefaultAccountRequest
import com.example.combanquemisrspeedo.model.ChangePasswordRequest
import com.example.combanquemisrspeedo.model.CountryDTO
import com.example.combanquemisrspeedo.model.LoginRequest
import com.example.combanquemisrspeedo.model.LoginResponseDTO
import com.example.combanquemisrspeedo.model.RegisterRequest
import com.example.combanquemisrspeedo.model.RemoveCardRequest
import com.example.combanquemisrspeedo.model.TransactionDTO
import com.example.combanquemisrspeedo.model.TransferRequest
import com.example.combanquemisrspeedo.model.UpdateAccountRequest
import com.example.combanquemisrspeedo.model.UserDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserAPICallable {

    // User Management

    @POST("/api/register")
    suspend fun register(@Body registerRequest: RegisterRequest): UserDTO

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponseDTO

    @POST("/api/logout")
    suspend fun logout(): String

    // Account Information

    @GET("/api/user")
    suspend fun getUser(): UserDTO

    @GET("/api/transactions")
    suspend fun getTransactions(): List<TransactionDTO>

    @GET("/api/accounts")
    suspend fun getAccounts(): List<AccountDTO>

    @PUT("/api/user")
    suspend fun updateAccount(@Body updateAccountRequest: UpdateAccountRequest): UserDTO

    @PUT("/api/password")
    suspend fun changePassword(@Body changePasswordRequest: ChangePasswordRequest): Any // Replace 'Any' with actual response type

    // Card Management

    @POST("/api/accounts")
    suspend fun addAccount(@Body addCardRequest: AddAccountRequest): List<AccountDTO>

    @GET("/api/accounts")
    suspend fun getCards(): List<AccountDTO>

    @DELETE("/api/accounts")
    suspend fun removeCard(@Body removeCardRequest: RemoveCardRequest): Any // Replace 'Any' with actual response type

    @PUT("/api/accounts/default")
    suspend fun changeDefaultAccount(@Body changeDefaultCardRequest: ChangeDefaultAccountRequest) : Any // Replace 'Any' with actual response type

    // Favorite Management

    @POST("/api/favorites")
    suspend fun addFavorite(@Body addFavoriteRequest: AddFavoriteRequest): List<AccountDTO>

    @GET("/api/favorites")
    suspend fun getFavorites(): List<AccountDTO>

    @DELETE("/api/favorites/{accountNumber}")
    suspend fun deleteFavorite(@Path("accountNumber") accountNumber: String): List<AccountDTO>

    // Transfer

    @POST("/api/transfer")
    suspend fun transfer(@Body transferRequest: TransferRequest): Any // Replace 'Any' with actual response type

    //Countries
    @POST("/db/countries")
    suspend fun getCountries(): List<CountryDTO>
}