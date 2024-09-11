package com.example.combanquemisrspeedo.model

import org.jetbrains.annotations.NotNull


// TokenStorage.kt
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object TokenStorage {
    private const val PREFS_NAME = "TokenPrefs"
    private const val TOKEN_KEY = "authToken"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken(context: Context, token: String) {
        getSharedPreferences(context).edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(context: Context): String? {
        return getSharedPreferences(context).getString(TOKEN_KEY, null)
    }

    fun clearToken(context: Context) {
        getSharedPreferences(context).edit().remove(TOKEN_KEY).apply()
    }
}

object TokenStoragee {
    private var token: String? = null

    fun getToken(): String? {
        return token
    }

    fun setToken(newToken: String) {
        token = newToken
    }
}




