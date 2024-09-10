package com.example.combanquemisrspeedo.model.signUpData

data class RegisterRequestDTO(
    val name: String,
    val email: String,
    val password: String,
    val country: String,
    val dateOfBirth: String
)

data class RegisterResponseDTO(
    val id: Int,
    val name: String,
    val email: String,
    val createdAt: String,
    val updatedAt: String
)