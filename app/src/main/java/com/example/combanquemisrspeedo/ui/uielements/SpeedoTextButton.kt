package com.example.combanquemisrspeedo.ui.uielements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.model.animateTranslation

@Composable
fun SpeedoTextButton(text: String,
                     textColor: Color,
                     backgroundColor: Color,
                     borderColor: Color,
                     modifier: Modifier = Modifier,
                     onclick: () -> Unit,
){
    TextButton(
        onClick = onclick,
        modifier = Modifier
            .height(51.dp)
            .width(343.dp)
            .border(
                width = 1.5.dp,
                color = borderColor,
                shape = RoundedCornerShape(6.dp)
            )

            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(6.dp))
    ) {
        Text(
            text,
            color = textColor,
            fontSize = 16.sp,
            lineHeight = 20.8.sp,
            fontWeight = FontWeight(500),
        )
    }

}