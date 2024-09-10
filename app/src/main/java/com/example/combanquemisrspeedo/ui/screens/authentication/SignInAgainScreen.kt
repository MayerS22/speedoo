package com.example.combanquemisrspeedo.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.CustomSnackBar
import com.example.combanquemisrspeedo.model.isNetworkAvailable
import com.example.combanquemisrspeedo.ui.screens.error.InternetError
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SignInAgain(navController: NavController, modifier: Modifier = Modifier) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    var showTimeoutDialog by remember { mutableStateOf(true) } // Control the visibility of the dialog
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    // Determine if the button should be fully opaque or semi-transparent
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

    if (isConnected.value){

    Scaffold(
        content = { _ ->


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
            ) {
                if (showTimeoutDialog) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Hello, Jetpack Compose!"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(70.dp)) // To push the content down if needed

                Text(
                    text = stringResource(R.string.welcome_back),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = G900,
                    modifier = Modifier
                        .padding(top = 70.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally) // Center text
                )
                Text(
                    text = stringResource(R.string.login_to_your_account),
                    fontSize = 16.sp,
                    color = Color(0xFF565552),
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 70.dp)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally) // Center text
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
                )
                {
                    if (isButtonEnabled) {
                        // Perform sign-in action
                    }
                }
            }
                Box(
                    modifier = Modifier.padding(8.dp),
                    contentAlignment = Alignment.TopCenter, //Change to your desired position
                ) {
                    SnackbarHost(hostState = snackbarHostState,
                        snackbar = { CustomSnackBar(
                            it,
                            { it.dismiss() }
                        )
                        })
                }
        }

    )

        }
    else {
//InternetError()
    }
}