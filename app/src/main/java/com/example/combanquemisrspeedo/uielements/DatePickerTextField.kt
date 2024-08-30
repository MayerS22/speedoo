package com.example.combanquemisrspeedo.uielements

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar


@Composable
fun DatePickerTextField(
    labelText: String,
    placeholderText: String,
    trailingIcon: Painter,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current // Get the current context
    val calendar = Calendar.getInstance() // Get the current instance of Calendar
    val date = remember { mutableStateOf("") }

    // DatePickerDialog Setup
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val selectedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
            date.value = selectedDate
            onDateSelected(selectedDate)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = labelText,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = date.value,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .clickable { datePickerDialog.show() }, // Show DatePickerDialog on click
            shape = RoundedCornerShape(6.dp),
            placeholder = { Text(text = placeholderText) },
            trailingIcon = {
                Icon(
                    painter = trailingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp) // Set icon size to 24.dp
                )
            },
            readOnly = true // Make the text field read-only
        )
    }
}
