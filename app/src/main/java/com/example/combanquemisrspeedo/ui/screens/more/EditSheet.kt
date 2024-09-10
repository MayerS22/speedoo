package com.example.combanquemisrspeedo.ui.screens.more

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@Composable
fun EditSheet(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(515.dp)
            .padding(bottom = 100.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = "",
                tint =P300
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Edit",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
                )
        }
        Spacer(modifier = Modifier.height(20.dp))
        SpeedoTextField(
            labelText = "Recipient Account",
            placeholderText = "Enter Cardholder Name",
            onTextChange = {},
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        SpeedoTextField(
            labelText = "Recipient Name",
            placeholderText = "Enter Cardholder Name",
            onTextChange = {},
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        SpeedoTextButton(
            text = "Save",
            textColor = White,
            backgroundColor = P300,
            borderColor = P300
        ) {}
    }
}

@Preview
@Composable
private fun EditSheetPreview() {
    EditSheet()
}