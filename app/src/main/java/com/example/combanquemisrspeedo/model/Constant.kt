package com.example.combanquemisrspeedo.model


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Function to perform translation animation (horizontal movement)
@Composable
fun Modifier.animateTranslation(scope: CoroutineScope, durationMillis: Int = 700): Modifier {
    val animatedOffsetX = remember { Animatable(1000f) } // Start offset, simulates "fromXDelta"

    scope.launch {
        // Animate X translation from 1000f to 0f
        animatedOffsetX.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = durationMillis)
        )
    }

    return this.offset { IntOffset(animatedOffsetX.value.toInt(), 0) }
}
