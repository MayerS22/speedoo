package com.example.combanquemisrspeedo.ui.uielements

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.android_security.ui.theme.White
import java.util.Calendar


@Composable
fun DatePickerTextField(
    labelText: String,
    placeholderText: String,
    trailingIcon: Painter,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedDate by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Current date for validation
    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonth = calendar.get(Calendar.MONTH)
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val selectedCalendar = Calendar.getInstance()
            selectedCalendar.set(year, month, dayOfMonth)

            // Calculate the age
            val age = currentYear - year - if (currentMonth < month || (currentMonth == month && currentDay < dayOfMonth)) 1 else 0

            if (age >= 18) {
                selectedDate = "$dayOfMonth/${month + 1}/$year"
                errorMessage = ""
                onDateSelected(selectedDate)
            } else {
                errorMessage = "You must be at least 18 years old"
            }
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    val borderColor = Color.Gray
    val textColor = Color.Black
    val placeholderColor = Color.Gray
    val backgroundColor = White
    val errorColor = Color.Red

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = labelText,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { datePickerDialog.show() }
                .border(1.dp, if (errorMessage.isEmpty()) borderColor else errorColor, RoundedCornerShape(6.dp))
                .background(backgroundColor, RoundedCornerShape(6.dp))
                .padding(16.dp)
        ) {
            Text(
                text = if (selectedDate.isEmpty()) placeholderText else selectedDate,
                color = if (selectedDate.isEmpty()) placeholderColor else if (errorMessage.isEmpty()) textColor else errorColor,
                style = TextStyle(fontSize = 16.sp)
            )
            Icon(
                painter = trailingIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd)
            )
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = errorColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}
