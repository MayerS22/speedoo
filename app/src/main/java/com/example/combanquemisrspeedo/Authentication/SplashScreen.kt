package com.example.combanquemisrspeedo.Authentication

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.P500
import edu.android_security.ui.theme.SplashScreenHeading
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val circleRadius = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            circleRadius.animateTo(
                targetValue = 3000f,
                animationSpec = tween(durationMillis = 3500)
            )
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = P500,
                    radius = circleRadius.value,
                    center = center
                )
            }

            if (circleRadius.value > 1000f) {
                Text(
                    text = "Speedo Transfer",
                    color = G0,
                    style = SplashScreenHeading
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}