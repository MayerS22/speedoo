package com.example.combanquemisrspeedo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.P500
import edu.android_security.ui.theme.SplashScreenHeading


@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = P500
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Text(
                text = "Speedo Transfer",
                color = G0,
                style = SplashScreenHeading
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}