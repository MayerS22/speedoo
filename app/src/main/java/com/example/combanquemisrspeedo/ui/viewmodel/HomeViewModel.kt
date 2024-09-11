package com.example.combanquemisrspeedo.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.combanquemisrspeedo.api.UserAPICallable
import com.example.combanquemisrspeedo.api.UserAPIService
import com.example.combanquemisrspeedo.model.userDato.UserDTO
import com.example.combanquemisrspeedo.ui.screens.main.transfer.Transaction
import com.example.combanquemisrspeedo.ui.screens.main.transfer.transactionsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val userRepository = UserRepository() // Adjust to use the service directly if needed

    private val _account = MutableStateFlow<UserDTO?>(null)
    val account: StateFlow<UserDTO?> = _account

    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    fun getAccountDetails(userId: Long) {
        viewModelScope.launch {
            try {
                val response = userRepository.getUserDetails(userId)
                if (response.isSuccessful) {
                    _account.value = response.body()
                } else {
                    Log.e("HomeViewModel", "Error fetching account details: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error fetching account details: ${e.message}")
            }
        }
    }

    fun getRecentTransactions() {
        // Mocked transactions data for now
        _transactions.value = transactionsList // Replace with real API call if available
    }
}

class UserRepository {
    private val userAPIService = UserAPIService.createService()

    suspend fun getUserDetails(userId: Long): Response<UserDTO> {
        return userAPIService.getUserById(userId)
    }
}


