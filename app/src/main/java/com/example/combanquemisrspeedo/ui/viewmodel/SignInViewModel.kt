package com.example.combanquemisrspeedo.ui.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.test.core.app.ApplicationProvider
import com.example.combanquemisrspeedo.api.SignInAPIService
import com.example.combanquemisrspeedo.api.SignUpAPIService
import com.example.combanquemisrspeedo.model.TokenStorage
import com.example.combanquemisrspeedo.model.TokenStoragee
import com.example.combanquemisrspeedo.model.signInData.SignInRequest
import com.example.combanquemisrspeedo.model.signInData.SignInResponse
import com.example.combanquemisrspeedo.model.signInData.SignInState
import com.example.combanquemisrspeedo.model.signUpData.RegisterRequestDTO
import com.example.combanquemisrspeedo.model.signUpData.RegisterResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SignInViewModel : ViewModel() {


    private val repository = RepositorySignIn()
    private val _signInState = MutableStateFlow<SignInState>(SignInState.Idle)
    val signInState: StateFlow<SignInState> = _signInState
    private val _userId = mutableStateOf<Long?>(null)
    val userId: State<Long?> get() = _userId
    private val _token = mutableStateOf<String?>(null)
    val token: State<String?> get() = _token
    private val _loginState = mutableStateOf<Boolean?>(null)
    val loginState: State<Boolean?> = _loginState

    fun handleLoginResponse(response: SignInResponse) {
        _userId.value = response.userid.toLong()
        _token.value = response.token
    }

    fun signIn(email: String, password: String,context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            _signInState.value = SignInState.Loading
            try {
                val response = repository.signIn(SignInRequest(email, password))
                if (response != null) {
                    handleLoginResponse(response)
                    _signInState.value = SignInState.Success(response)
                    val token = response.token
                    TokenStorage.saveToken(context, token)
                    TokenStoragee.setToken(token)

                    // Log the token for debugging purposes
                    Log.d("SignInViewModel", "Token saved: $token")
                    Log.d("SignInViewModel", "Token saved SP: ${TokenStorage.getToken(context)}")

                    // Update the login state to true
                    _loginState.value = true
                } else {
                    _signInState.value = SignInState.Error("Sign-in failed")
                }
            } catch (e: Exception) {
                _signInState.value = SignInState.Error("Error occurred: ${e.message}")
            }
        }
    }
}


class RepositorySignIn {
    suspend fun signIn(signInRequest: SignInRequest): SignInResponse? {
        return try {
            val response = SignInAPIService.userAPI.signIn(signInRequest)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("Repository", "Sign-in successful: ${it}")
                    it
                }
            } else {
                Log.e("Repository", "Sign-in failed: ${response.code()} - ${response.message()}")
                null
            }
        } catch (e: Exception) {
            Log.e("Repository", "Error occurred: ${e.message}", e)
            null
        }
    }
}