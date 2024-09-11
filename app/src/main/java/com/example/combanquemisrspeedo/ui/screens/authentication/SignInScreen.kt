package com.example.combanquemisrspeedo.ui.screens.authentication

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.TokenStorage
import com.example.combanquemisrspeedo.model.TokenStoragee
import com.example.combanquemisrspeedo.model.isNetworkAvailable
import com.example.combanquemisrspeedo.model.signInData.SignInState
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.ui.screens.error.InternetError
import com.example.combanquemisrspeedo.ui.uielements.SignText
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import com.example.combanquemisrspeedo.ui.viewmodel.SignInViewModel
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White
import kotlinx.coroutines.delay


@Composable
fun SignInScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: SignInViewModel = viewModel() // No factory needed
    val signInState by viewModel.signInState.collectAsState()
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    // Determine the button color based on whether both fields have input
    val isButtonEnabled = email.isNotEmpty() && password.isNotEmpty()
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)

    val isConnected = remember { mutableStateOf(true) }
    var buttonClicked by remember { mutableStateOf(false) }

    // Periodically check network status using LaunchedEffect
    LaunchedEffect(Unit) {
        while (true) {
            isConnected.value = isNetworkAvailable(context)
            delay(1000L) // Adjust delay as necessary
        }
    }


    LaunchedEffect(signInState) {
        when (signInState) {
            is SignInState.Success -> {
                val accountId = (signInState as SignInState.Success).accountId
                fun onLoginSuccess(token: String) {
                    TokenStoragee.setToken(token)
                    // Proceed with the rest of your logic, like navigating to another screen
                }

                Log.d("SignInScreen", "Navigation to BOTTOMNAVSCREEN with accountId: $accountId")
                navController.navigate("${Route.BOTTOMNAVSCREEN}/$accountId") {
                    popUpTo(Route.SIGNIN) { inclusive = true }
                }
            }
            is SignInState.Error -> {
                val errorMessage = (signInState as SignInState.Error).message
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                Log.e("SignInScreen", "Sign-in error: $errorMessage")
                buttonClicked = false
            }
            else -> {
                // Handle other states if necessary
            }
        }
    }
    if (isConnected.value) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFFF8E7),
                            Color(0xFFFFEAEE),
                        )
                    )
                )
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.sign_in),
                fontSize = 20.sp,
                color = G900,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.speedo_transfer),
                fontSize = 24.sp,
                color = G900,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 70.dp, bottom = 70.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            SpeedoTextField(
                labelText = stringResource(R.string.email),
                placeholderText = stringResource(R.string.enter_you_email),
                trailingIcon = painterResource(id = R.drawable.email),
                onTextChange = { newText -> email = newText },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            SpeedoTextField(
                labelText = stringResource(R.string.password),
                placeholderText = stringResource(R.string.enter_your_password),
                trailingIcon = painterResource(id = R.drawable.email), // Update with appropriate icon for password visibility
                onTextChange = { newText -> password = newText },
                isPassword = true,
                passwordVisible = passwordVisible,
                onPasswordVisibilityToggle = { passwordVisible.value = !passwordVisible.value },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 24.dp)
                    .fillMaxWidth()
            )
            SpeedoTextButton(
                text = stringResource(R.string.sign_in),
                textColor = White,
                backgroundColor = buttonColor,
                borderColor = buttonColor
            ) {
                if (isButtonEnabled) {
                    buttonClicked = true
                    viewModel.signIn(email, password,context)
                }
            }

            SignText(
                firstText = stringResource(R.string.don_t_have_an_account),
                secondText = stringResource(R.string.sign_up)
            ) {
                navController.navigate(Route.SIGNUP)
            }
        }
    } else {
        InternetError()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen(rememberNavController())
}



fun saveData(email: String, password: String, cbState: Boolean, context: Context) {
    val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
    if (cbState) {
        editor.putString("email", email)
        editor.putString("password", password)
    } else {
        editor.putString("email", "")
        editor.putString("password", "")
    }
    editor.apply()
}


