package com.example.combanquemisrspeedo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.combanquemisrspeedo.api.LoginAPIService
import com.example.combanquemisrspeedo.model.LoginRequest
import com.example.combanquemisrspeedo.model.LoginResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel() : ViewModel() {

    private val emptyLoginDTO: LoginResponseDTO = LoginResponseDTO(
        userid = 0.0,
        token = "",
        tokenType = "",
        message = "",
        status = ""
    )

    private val _loginResponse = MutableStateFlow<LoginResponseDTO?>(emptyLoginDTO)
    val loginResponse = _loginResponse.asStateFlow()


    fun saveLoginResponse(loginResponseDTO: LoginResponseDTO?) {
        _loginResponse.update {
            loginResponseDTO
        }
        Log.d("TAG", "saveLoginResponse: ${loginResponse.value}")

    }


    fun callLoginAPI(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val loginRequest = LoginRequest("string@st", "stringst")
                Log.d("TAG", "Logging in: $loginRequest")
                LoginAPIService.loginAPI.login(loginRequest)

            } catch (e: Exception) {
                Log.d("TAG", "Logging in Error: ${e.message}")
            }
        }
    }
}