package com.example.combanquemisrspeedo.ui.screens.authentication

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.model.TokenStorage
import com.example.combanquemisrspeedo.navigation.Route
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.P500
import edu.android_security.ui.theme.SplashScreenHeading
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController,context: Context, modifier: Modifier = Modifier) {
    val circleRadius = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val textProgress = remember { Animatable(0f) }
    val fullText = "Speedo Transfer "

    //circlee
    LaunchedEffect(Unit) {
        val prefs = context.getSharedPreferences("OnboardingPrefs", Context.MODE_PRIVATE)
        val onboardingCompleted = prefs.getBoolean("onboardingCompleted", false)
        scope.launch {
            circleRadius.animateTo(
                targetValue = 3000f,
                animationSpec = tween(durationMillis = 5000)
            )
        }

        // Animate the text
        scope.launch {
            delay(2000)  // Delay before starting text animation
            textProgress.animateTo(
                targetValue = fullText.length.toFloat(),
                animationSpec = tween(durationMillis = 3000)
            )
            val token = TokenStorage.getToken(context)
            val isOnboardingCompleted = getIsOnboardingCompleted(context) // Add this function below

            when {
//                token != null -> navController.navigate(Route.BOTTOMNAVSCREEN) {
//                    popUpTo(Route.START) { inclusive = true }
//                }
                isOnboardingCompleted -> navController.navigate(Route.SIGNIN) {
                    popUpTo(Route.START) { inclusive = true }
                }
                else -> navController.navigate(Route.ONBOARDING) {
                    popUpTo(Route.START) { inclusive = true }
                }
            }
        }
    }


//        // Navigate after animations are complete
//        scope.launch {
//            delay(5000)  // Adjust this delay to match the total animation duration
//            navController.navigate(Route.ONBOARDING) {
//                popUpTo(Route.START) { inclusive = true }
//            }
//    }}

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

            if (circleRadius.value > 2000f) {
                val visibleText =
                    fullText.substring(0, textProgress.value.toInt().coerceIn(0, fullText.length))
                Text(
                    text = visibleText,
                    color = G0,
                    style = SplashScreenHeading
                )
            }

            }
        }
}

fun getIsOnboardingCompleted(context: Context): Boolean {
    val prefs = context.getSharedPreferences("OnboardingPrefs", Context.MODE_PRIVATE)
    return prefs.getBoolean("onboardingCompleted", false)
}


