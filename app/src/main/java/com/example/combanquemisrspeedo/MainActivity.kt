package com.example.combanquemisrspeedo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.combanquemisrspeedo.Authentication.SplashScreen
import com.example.combanquemisrspeedo.authentication.SignUpScreen1

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(10.dp))
            {
                SplashScreen()
            }
        }

    }

    @Preview
    @Composable
    fun DText() {
        Box(Modifier.background(Color.White)) {
            Text(text = "Hello World")
        }
    }


}