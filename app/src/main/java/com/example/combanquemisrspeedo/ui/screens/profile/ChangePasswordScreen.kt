package com.example.combanquemisrspeedo.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassword(navController: NavController) {

    var currentPassword by remember { mutableStateOf("") }
    val currentPasswordError = remember { mutableStateOf<String?>(null) }
    val newPasswordError = remember { mutableStateOf<String?>(null) }
    val hasTypedPassword = remember { mutableStateOf(false) }
    val hasTypednewPassword = remember { mutableStateOf(false) }
    var newPassword by remember { mutableStateOf("") }
    val currentPasswordVisible = remember { mutableStateOf(false) }
    val newPasswordVisible = remember { mutableStateOf(false) }

    val isButtonEnabled = currentPassword.isNotEmpty() && newPassword.isNotEmpty()
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF8E7),
                        Color(0xFFFFEAEE),
                    )
                )
            ),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.change_password),
                        fontSize = 20.sp,
                        color = G900,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                    //navController.navigate(Route.SETTING)
                        navController.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.size(35.dp))

                SpeedoTextField(
                    labelText = stringResource(R.string.current_password),
                    placeholderText = stringResource(R.string.enter_your_password),
                    trailingIcon = if (currentPasswordVisible.value) {
                        painterResource(id = R.drawable.openeye)
                    } else {
                        painterResource(id = R.drawable.eyeclose)
                    },
                    onTextChange = { currentPassword = it
                        hasTypedPassword.value = true
                        currentPassword = it
                        currentPasswordError.value= validatePassword(it)
                                   },
                    isPassword = true,
                    passwordVisible = currentPasswordVisible,
                    onPasswordVisibilityToggle = {
                        currentPasswordVisible.value = !currentPasswordVisible.value
                    },
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    errorMessage = if (hasTypedPassword.value) currentPasswordError.value else null,
                    errorColor = if (hasTypedPassword.value) Color.Red else Color.Transparent
                )

                SpeedoTextField(
                    labelText = stringResource(R.string.new_password),
                    placeholderText = stringResource(R.string.enter_your_password),
                    trailingIcon = if (newPasswordVisible.value) {
                        painterResource(id = R.drawable.openeye)
                    } else {
                        painterResource(id = R.drawable.eyeclose)
                    },
                    onTextChange = {  newPassword = it
                        hasTypedPassword.value = true
                        newPasswordError.value= validatePassword(it)
                        newPasswordError.value = validatenewPassword(it, currentPassword)
                    },
                    isPassword = true,
                    passwordVisible = newPasswordVisible,
                    onPasswordVisibilityToggle = {
                        newPasswordVisible.value = !newPasswordVisible.value
                    },
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    errorMessage = if (hasTypedPassword.value) newPasswordError.value else null,
                    errorColor = if (hasTypedPassword.value) Color.Red else Color.Transparent
                )



                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    SpeedoTextButton(
                        text = stringResource(R.string.save),
                        textColor = White,
                        backgroundColor = buttonColor,
                        borderColor = buttonColor
                    ) {
                        if (isButtonEnabled) {
                            // Handle password change logic here
                        }
                    }
                }
            }
        }
    )
}


fun validatenewPassword(currentPassword: String, newPassword: String): String? {
    return if (newPassword.isNotEmpty() && currentPassword != newPassword) {
        "Passwords do not match"
    } else {
        null
    }
}
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

@Preview(showBackground = true)
@Composable
fun ChangePasswordPreview() {
    ChangePassword( rememberNavController())
}
