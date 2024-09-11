package com.example.combanquemisrspeedo.model.accountData

data class AccountDTO(
    val id: Long,
    val accountNumber: String,
    val accountType: String, // Enum (SAVINGS, CURRENT)
    val balance: Double,
    val currency: String, // Enum (EGP, USD, EUR, GBP, SAR)
    val accountName: String,
    val accountDescription: String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)