package com.example.combanquemisrspeedo.model

import androidx.annotation.DrawableRes
import com.example.combanquemisrspeedo.R

// Data class
data class Country(
    val name: String,
    @DrawableRes val flagResId: Int
)

// List of countries
val countries = listOf(
    Country("United States", R.drawable.bank),
    Country("Canada", R.drawable.email),
    Country("United Kingdom", R.drawable.country)
    // Continue adding more countries as needed
)


