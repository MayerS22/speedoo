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
import com.example.combanquemisrspeedo.more.MoreScreen
import com.example.combanquemisrspeedo.navigation.AppNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column()
            {
                MoreScreen()
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