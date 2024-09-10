package com.example.combanquemisrspeedo.ui.uielements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.P300

@Composable
fun SignText(
    firstText: String,
    secondText: String,
    firstTextColor: Color = G100,
    secondTextColor: Color = P300,
    firstTextFontSize: TextUnit = 16.sp,
    secondTextFontSize: TextUnit = 16.sp,
    onSecondTextClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = firstText,
            style = TextStyle(
                fontSize = firstTextFontSize,
                color = firstTextColor
            ),
        )
        ClickableText(
            modifier = Modifier.padding(start = 5.dp),
            text = AnnotatedString(secondText),
            style = TextStyle(
                fontSize = secondTextFontSize,
                fontWeight = FontWeight.Bold,
                color = secondTextColor,
                textDecoration = TextDecoration.Underline
            ),
           onClick =onSecondTextClick
        )
    }
}