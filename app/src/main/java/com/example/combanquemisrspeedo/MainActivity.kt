package com.example.combanquemisrspeedo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.authentication.SignUpScreen2
import com.example.combanquemisrspeedo.navigation.AppNavHost
import com.example.combanquemisrspeedo.profile.EditProfile

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

           SignUpScreen2(rememberNavController())

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