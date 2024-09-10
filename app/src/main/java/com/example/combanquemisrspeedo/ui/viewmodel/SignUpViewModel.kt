package com.example.combanquemisrspeedo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.combanquemisrspeedo.api.SignUpAPIService
import com.example.combanquemisrspeedo.model.signUpData.RegisterRequestDTO
import com.example.combanquemisrspeedo.model.signUpData.RegisterResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {


    private val repository = Repository()
    private val _signUpResponse = MutableStateFlow<Boolean?>(null)
    val signUpResponse = _signUpResponse.asStateFlow()

    fun signUp(
        name: String,
        email: String,
        password: String,
        country: String,
        dateOfBirth: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val signUpRequest = RegisterRequestDTO(
                name, email, password, country, dateOfBirth
            )
            val result = repository.signUp(signUpRequest)
            _signUpResponse.value = result != null
        }
    }
}

class Repository {
    suspend fun signUp(signUpRequest: RegisterRequestDTO): RegisterResponseDTO? {
        return try {
            val response = SignUpAPIService.callable.signUp(signUpRequest)
            if (response.isSuccessful) {
                val responseBody = response.body()
                Log.d("Repository", "SignUp successful: $responseBody")
                responseBody
            } else {
                Log.e("Repository", "SignUp failed: ${response.code()} - ${response.message()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Error occurred: ${e.message}", e)
            null
        }
    }
}