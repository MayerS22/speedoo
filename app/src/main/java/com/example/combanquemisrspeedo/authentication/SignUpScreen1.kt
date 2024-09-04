package com.example.combanquemisrspeedo.authentication

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.uielements.SignText
import com.example.combanquemisrspeedo.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.uielements.SpeedoTextField
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@Composable
fun SignUpScreen1(navController: NavController, modifier: Modifier = Modifier) {
    val fullName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf<String?>(null) }
    val confirmPasswordError = remember { mutableStateOf<String?>(null) }
    val hasTypedPassword = remember { mutableStateOf(false) } // Track if the user has started typing in the password field
    val hasTypedConfirmPassword = remember { mutableStateOf(false) } // Track if the user has started typing in the confirm password field

    // Password validation function
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

    // Confirm password validation function
    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        return if (confirmPassword.isNotEmpty() && password != confirmPassword) {
            "Passwords do not match"
        } else {
            null
        }
    }

    val isButtonEnabled = fullName.value.isNotEmpty() &&
            email.value.isNotEmpty() &&
            password.value.isNotEmpty() &&
            confirmPassword.value.isNotEmpty() &&
            passwordError.value == null &&
            confirmPasswordError.value == null

    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)

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
            onTextChange = { email.value = it },
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        SpeedoTextField(
            labelText = stringResource(R.string.password),
            placeholderText = stringResource(R.string.enter_your_password),
            trailingIcon = painterResource(id = R.drawable.eyeclose), // Replace with the correct icon
            onTextChange = {
                hasTypedPassword.value = true // Mark that the user has typed in the password field
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
            errorMessage = if (hasTypedPassword.value) passwordError.value else null, // Show error only after typing starts
            errorColor = if (hasTypedPassword.value) Color.Red else Color.Transparent // Show the red color only after typing starts
        )
        SpeedoTextField(
            labelText = stringResource(R.string.confirm_password),
            placeholderText = stringResource(R.string.enter_your_password),
            trailingIcon = painterResource(id = R.drawable.eyeclose), // Replace with the correct icon
            onTextChange = {
                hasTypedConfirmPassword.value = true // Mark that the user has typed in the confirm password field
                confirmPassword.value = it
                confirmPasswordError.value = validateConfirmPassword(password.value, it)
            },
            isPassword = true,
            passwordVisible = passwordVisible,
            onPasswordVisibilityToggle = { passwordVisible.value = !passwordVisible.value },
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 24.dp)
                .fillMaxWidth(),
            errorMessage = if (hasTypedConfirmPassword.value) confirmPasswordError.value else null, // Show error only after typing starts
            errorColor = if (hasTypedConfirmPassword.value) Color.Red else Color.Transparent // Show the red color only after typing starts
        )
        SpeedoTextButton(
            text = stringResource(R.string.sign_up),
            textColor = White,
            backgroundColor = buttonColor,
            borderColor = buttonColor
        ) {
            if (isButtonEnabled) {
                navController.navigate(Route.SIGNUP2)
            }
        }

        SignText(
            firstText = stringResource(R.string.already_have_an_account),
            secondText = stringResource(R.string.sign_in),
            onSecondTextClick = { navController.navigate(Route.SIGNIN) }
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignUpScreen1(rememberNavController())
}
