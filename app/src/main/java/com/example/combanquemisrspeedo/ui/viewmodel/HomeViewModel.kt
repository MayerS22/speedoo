package com.example.combanquemisrspeedo.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.combanquemisrspeedo.api.AccountAPIService
import com.example.combanquemisrspeedo.model.accountData.AccountDTO
import com.example.combanquemisrspeedo.ui.screens.main.transfer.Transaction
import com.example.combanquemisrspeedo.ui.screens.main.transfer.transactionsList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _account = mutableStateOf<AccountDTO?>(null)
    val account: State<AccountDTO?> = _account

    private val _transactions = mutableStateOf<List<Transaction>>(emptyList())
    val transactions: State<List<Transaction>> = _transactions

    private val _accountId = MutableStateFlow<Long?>(null)
    val accountId: StateFlow<Long?> = _accountId

    // Function to get account details
    fun getAccountDetails(accountId: Long) {
        viewModelScope.launch {
            try {
                val accountDetails = AccountAPIService.userAPI.getAccountById(accountId)
                _account.value = accountDetails
                _accountId.value = accountId
            } catch (e: Exception) {
                // Handle error here (e.g., log it or show a message to the user)
                Log.e("HomeViewModel", "Error fetching account details", e)
            }
        }
    }

    // Function to get recent transactions
    fun getRecentTransactions() {
        // In reality, this should call the API for transactions. Here we are using the static list.
        _transactions.value = transactionsList
    }
}
