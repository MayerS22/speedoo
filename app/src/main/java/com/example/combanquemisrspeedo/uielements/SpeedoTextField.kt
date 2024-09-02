package com.example.combanquemisrspeedo.uielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.White

@Composable
fun SpeedoTextField(
    labelText: String,
    placeholderText: String,
    trailingIcon: Painter? = null,
    onTextChange: (String) -> Unit,
    isPassword: Boolean = false,
    passwordVisible: MutableState<Boolean>? = null, // Optional for password fields
    onPasswordVisibilityToggle: (() -> Unit)? = null, // Optional for password fields
    modifier: Modifier = Modifier
) {
    val text = remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth()

    ) {
        Text(
            text = labelText,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)

        )
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = text.value,
            onValueChange = { newText ->
                text.value = newText
                onTextChange(newText)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp).background(color = White),
            shape = RoundedCornerShape(6.dp),
            placeholder = { Text(text = placeholderText) },
            visualTransformation = if (isPassword && passwordVisible?.value == false) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                when {
                    isPassword && passwordVisible != null -> {
                        val icon = if (passwordVisible.value) {
                            painterResource(id = R.drawable.openeye)
                        } else {
                            painterResource(id = R.drawable.eyeclose)
                        }
                        IconButton(onClick = { onPasswordVisibilityToggle?.invoke() }) {
                            Icon(
                                painter = icon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    trailingIcon != null -> {
                        Icon(
                            painter = trailingIcon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SpeedoTextFieldPreview() {
    val passwordVisible = remember { mutableStateOf(false) }
    SpeedoTextField(
        labelText = "Password",
        placeholderText = "Enter your password",
        trailingIcon = null, // This can be null now
        onTextChange = { /* Handle text change */ },
        isPassword = true,
        passwordVisible = passwordVisible,
        onPasswordVisibilityToggle = { passwordVisible.value = !passwordVisible.value }
    )
}
