package com.example.combanquemisrspeedo.Authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
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
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.uielements.SpeedoTextField
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@Composable
fun SignInAgain(modifier: Modifier = Modifier) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    var showTimeoutDialog by remember { mutableStateOf(true) }

    // Determine if the button should be fully opaque or semi-transparent
    val isButtonEnabled = email.value.isNotEmpty() && password.value.isNotEmpty()
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        White,
                        P,
                    )
                )
            )
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = stringResource(R.string.welcome_back),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = G900,
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.login_to_your_account),
            fontSize = 16.sp,
            color = Color(0xFF565552),
            modifier = Modifier
                .padding(top = 20.dp, bottom = 70.dp)
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
            placeholderText = stringResource(R.string.enter_you_password),
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
                // Perform sign-in action
            }
        }
    }
}

/*@Composable
fun TimeoutAlertDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = stringResource(id = R.string.timeout_title))
        },
        text = {
            Text(text = stringResource(id = R.string.timeout_message))
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_timeout), // Your timeout icon
                contentDescription = stringResource(id = R.string.timeout_icon_description)
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.ok))
            }
        },
        modifier = Modifier.padding(top = 16.dp) // Adjust padding as needed
    )
}*/

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInAgainPreview() {
    SignInAgain()
}
