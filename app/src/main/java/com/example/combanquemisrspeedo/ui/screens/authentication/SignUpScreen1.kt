package com.example.combanquemisrspeedo.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.animateTranslation
import com.example.combanquemisrspeedo.model.isNetworkAvailable
import com.example.combanquemisrspeedo.ui.screens.error.InternetError
import com.example.combanquemisrspeedo.ui.uielements.SignText
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import com.example.combanquemisrspeedo.ui.viewmodel.SignUpViewModel
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SignUpScreen1(navController: NavController, modifier: Modifier = Modifier) {
    val fullName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf<String?>(null) }
    val confirmPasswordError = remember { mutableStateOf<String?>(null) }
    val emailError = remember { mutableStateOf<String?>(null) }
    val hasTypedPassword = remember { mutableStateOf(false) }
    val hasTypedConfirmPassword = remember { mutableStateOf(false) }
    val hasTypedEmail = remember { mutableStateOf(false) }
    val viewModel: SignUpViewModel = viewModel()
    val signUpSuccess by viewModel.signUpResponse.collectAsState()

    // Animation for Sign Up Button
    val animatedModifier = Modifier.animateTranslation(rememberCoroutineScope())

    // Functions for validation
    fun validatePassword(password: String): String? {
        return when {
            password.length < 6 -> "Password must be at least 6 characters long"
            !password.any { it.isUpperCase() } -> "Password must contain at least one uppercase letter"
            !password.any { it.isLowerCase() } -> "Password must contain at least one lowercase letter"
            !password.any { it.isDigit() } -> "Password must contain at least one digit"
            !password.any { "!@#$%^&*()_+[]{}|;:'\",.<>?".contains(it) } -> "Password must contain at least one special character"
            else -> null
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        return if (confirmPassword.isNotEmpty() && password != confirmPassword) {
            "Passwords do not match"
        } else {
            null
        }
    }

    fun validateEmail(email: String): String? {
        return if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            "Invalid email address"
        } else {
            null
        }
    }

    val isButtonEnabled = fullName.value.isNotEmpty() &&
            email.value.isNotEmpty() &&
            password.value.isNotEmpty() &&
            confirmPassword.value.isNotEmpty() &&
            passwordError.value == null &&
            confirmPasswordError.value == null &&
            emailError.value == null
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)

    val context = LocalContext.current
    val isConnected = remember { mutableStateOf(true) }

    // Periodically check network status using LaunchedEffect
    LaunchedEffect(Unit) {
        while (true) {
            isConnected.value = isNetworkAvailable(context)
            delay(1000L) // Adjust delay as necessary
        }
    }

    // Handle navigation when sign-up is successful
    LaunchedEffect(signUpSuccess) {
        if (signUpSuccess == true) {
            navController.navigate(Route.SIGNUP2) {
                // Clear the back stack to prevent returning to the previous screen
                popUpTo(Route.SIGNUP) { inclusive = true }
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
                .imePadding()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.sign_up),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.speedo_transfer),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 50.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            SpeedoTextField(
                labelText = stringResource(R.string.full_name),
                placeholderText = stringResource(R.string.enter_you_full_name),
                trailingIcon = painterResource(id = R.drawable.user),
                onTextChange = { fullName.value = it },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            SpeedoTextField(
                labelText = stringResource(R.string.email),
                placeholderText = stringResource(R.string.enter_you_email),
                trailingIcon = painterResource(id = R.drawable.email),
                onTextChange = {
                    hasTypedEmail.value = true
                    email.value = it
                    emailError.value = validateEmail(it)
                },
                keyboardType = KeyboardType.Email,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                errorMessage = if (hasTypedEmail.value) emailError.value else null,
                errorColor = if (hasTypedEmail.value) Color.Red else Color.Transparent
            )
            SpeedoTextField(
                labelText = stringResource(R.string.password),
                placeholderText = stringResource(R.string.enter_your_password),
                trailingIcon = painterResource(id = R.drawable.eyeclose),
                onTextChange = {
                    hasTypedPassword.value = true
                    password.value = it
                    passwordError.value = validatePassword(it)
                    confirmPasswordError.value = validateConfirmPassword(it, confirmPassword.value)
                },
                isPassword = true,
                passwordVisible = passwordVisible,
                onPasswordVisibilityToggle = { passwordVisible.value = !passwordVisible.value },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                errorMessage = if (hasTypedPassword.value) passwordError.value else null,
                errorColor = if (hasTypedPassword.value) Color.Red else Color.Transparent
            )
            SpeedoTextField(
                labelText = stringResource(R.string.confirm_password),
                placeholderText = stringResource(R.string.enter_your_confirm_password),
                trailingIcon = painterResource(id = R.drawable.eyeclose),
                onTextChange = {
                    hasTypedConfirmPassword.value = true
                    confirmPassword.value = it
                    confirmPasswordError.value = validateConfirmPassword(password.value, it)
                },
                isPassword = true,
                passwordVisible = passwordVisible,
                onPasswordVisibilityToggle = { passwordVisible.value = !passwordVisible.value },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 24.dp)
                    .fillMaxWidth(),
                errorMessage = if (hasTypedConfirmPassword.value) confirmPasswordError.value else null,
                errorColor = if (hasTypedConfirmPassword.value) Color.Red else Color.Transparent
            )
            SpeedoTextButton(
                text = stringResource(R.string.sign_up),
                textColor = White,
                backgroundColor = buttonColor,
                borderColor = buttonColor,
                modifier = animatedModifier
            ) {
                if (isButtonEnabled) {
                    viewModel.signUp(
                        fullName.value,
                        email.value,
                        password.value,
                        "Egypt",
                        "2003-02-15"
                    )
                }
            }

            SignText(
                firstText = stringResource(R.string.already_have_an_account),
                secondText = stringResource(R.string.sign_in),
                onSecondTextClick = {
                    navController.navigate(Route.SIGNIN)
                }
            )
        }
    } else {
        InternetError()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignUpScreen1(rememberNavController())
}
