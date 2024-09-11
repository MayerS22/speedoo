package com.example.combanquemisrspeedo.model.userDato


import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.time.LocalDateTime



data class UserDTO(
    val id: Long,
    val name: String,
    val email: String,
    val dateOfBirth: String, // Adjust to LocalDate if needed
    val country: String,
    val phoneNumber: String?,
    val createdAt: String, // Adjust to LocalDateTime if needed
    val updatedAt: String, // Adjust to LocalDateTime if needed
    val accounts: List<AccountDTO>
)

data class AccountDTO(
    val id: Long,
    val accountNumber: String,
    val accountType: String, // Adjust to Enum if needed
    val balance: Double,
    val currency: String, // Adjust to Enum if needed
    val accountName: String,
    val accountDescription: String,
    val active: Boolean,
    val createdAt: String, // Adjust to LocalDateTime if needed
    val updatedAt: String // Adjust to LocalDateTime if needed
)

