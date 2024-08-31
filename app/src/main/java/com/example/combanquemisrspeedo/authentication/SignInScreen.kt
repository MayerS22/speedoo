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
fun SignInScreen(navController: NavController, modifier: Modifier = Modifier) {
    val passwordVisible = remember { mutableStateOf(false) }

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
            .verticalScroll(
                rememberScrollState()
            )
    )  {
        Text(
            text = stringResource(R.string.sign_in),
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
                .padding(top = 70.dp, bottom = 70.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally) // Center text
        )
        SpeedoTextField(
            labelText = stringResource(R.string.email),
            placeholderText = stringResource(R.string.enter_you_email),
            trailingIcon = painterResource(id = R.drawable.email),
            onTextChange = {},
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        SpeedoTextField(
            labelText = stringResource(R.string.password),
            placeholderText = stringResource(R.string.enter_you_password),
            trailingIcon = painterResource(id = R.drawable.email), // This will be replaced with your icon for password visibility
            onTextChange = {},
            isPassword = true,
            passwordVisible = passwordVisible,
            onPasswordVisibilityToggle = { passwordVisible.value = !passwordVisible.value },
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 24.dp)
                .fillMaxWidth()
        )
        SpeedoTextButton(text = stringResource(R.string.sign_in), textColor = White, backgroundColor = P300, borderColor = P300)
        {
        }
        SignText(firstText = stringResource(R.string.don_t_have_an_account), secondText = stringResource(R.string.sign_up)){
            navController.navigate(Route.SIGNUP)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen(rememberNavController())
}
