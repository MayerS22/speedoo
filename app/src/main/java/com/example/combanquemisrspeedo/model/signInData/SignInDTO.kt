package com.example.combanquemisrspeedo.model.signInData

// SignInResponse.kt
data class SignInResponse(
    val userid: Int,
    val token: String,
    val tokenType: String,
    val message: String,
    val status: String
)

data class SignInRequest(
    val email: String,
    val password: String
)
sealed class SignInState {
    object Idle : SignInState()
    object Loading : SignInState()
    data class Success(val response: SignInResponse) : SignInState() {
        val accountId: Long = response.userid.toLong()
    }
    data class Error(val message: String) : SignInState()
}