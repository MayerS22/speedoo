package com.example.combanquemisrspeedo.ui.screens.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300

@Composable
fun InternetError(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            //.padding()
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF8E7),
                        P,
                    )
                )
            )
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.no_internet
            ),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Internet connection\n disabled...",
            fontWeight = FontWeight.W600,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = G900
            )
        Spacer(modifier = Modifier.height(20.dp))
        SpeedoTextButton(
            text = "Update",
            borderColor = P300,
            backgroundColor = P300,
            textColor = Color.White
        )
        { }

    }
}

@Preview
@Composable
private fun InternetErrorPreview() {
    InternetError()
}