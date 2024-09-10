package com.example.combanquemisrspeedo.ui.screens.main.transfer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.android_security.ui.theme.G700
import edu.android_security.ui.theme.P300

@SuppressLint("DefaultLocale")
@Composable
fun Stepper(currentStep: Int, totalSteps: Int = 3) {
    val steps = listOf("Amount", "Confirmation", "Payment") // Step labels

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..totalSteps) {
                // Display step number inside a circle with white background and P300 border
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Box to center the number inside the circle
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = Color.White,  // Set the background to white
                                shape = CircleShape
                            )
                            .border(
                                width = 2.dp,
                                color = if (i <= currentStep) P300 else Color(0xFFE0E0E0),  // Set border color based on the step
                                shape = CircleShape
                            )
                    ) {
                        // Step number formatted to 2 digits
                        Text(
                            text = String.format("%02d", i),  // Format to show 01, 02, 03
                            color = if (i <= currentStep) P300 else Color.Gray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Step label
                    Text(
                        text = steps[i - 1],
                        color = G700,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                // Add a divider between steps and move it upwards
                if (i < totalSteps) {
                    HorizontalDivider(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                            .offset(y = (-8).dp),  // Move the divider up
                        thickness = 2.dp,
                        color = if (i < currentStep) P300 else Color(0xFFE0E0E0)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStepper() {
    Stepper(currentStep =1)
}
