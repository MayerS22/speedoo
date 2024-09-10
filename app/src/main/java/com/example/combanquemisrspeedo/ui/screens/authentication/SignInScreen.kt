package com.example.combanquemisrspeedo.ui.screens.authentication

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.ui.screens.error.InternetError
import com.example.combanquemisrspeedo.model.isNetworkAvailable
import com.example.combanquemisrspeedo.ui.uielements.SignText
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SignInScreen(navController: NavController, modifier: Modifier = Modifier) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }

    // Determine the button color based on whether both fields have input

    val isButtonEnabled = email.value.isNotEmpty() && password.value.isNotEmpty()
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
                .verticalScroll(
                    rememberScrollState()
                )
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
                onTextChange = { email.value = it },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            SpeedoTextField(
                labelText = stringResource(R.string.password),
                placeholderText = stringResource(R.string.enter_your_password),
                trailingIcon = painterResource(id = R.drawable.email), // This will be replaced with your icon for password visibility
                onTextChange = { password.value = it },
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
                    navController.popBackStack()
                    navController.navigate(Route.BOTTOMNAVSCREEN)
                }
            }
            SignText(
                firstText = stringResource(R.string.don_t_have_an_account),
                secondText = stringResource(R.string.sign_up)
            ) {
                navController.navigate(Route.SIGNUP)
            }
        }
    }else {
            InternetError()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen(rememberNavController())
}
