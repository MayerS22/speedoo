package com.example.combanquemisrspeedo.uielements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun SpeedoTextField() {
    val text = remember {
        mutableStateOf("")
    }
    Column {
        Text(
            text = "Full Name",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 10.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = text.value, onValueChange = { it ->
                text.value = it
            },
            modifier = Modifier
                .padding(start = 10.dp),
            shape = RoundedCornerShape(6.dp),
            placeholder = {
                Text(text = "Enter your Full Name")
            }, trailingIcon = {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "")
            }

        )

    }

}