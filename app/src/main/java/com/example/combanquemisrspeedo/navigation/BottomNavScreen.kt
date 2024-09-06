package com.example.combanquemisrspeedo.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.more.MoreScreen
import com.example.combanquemisrspeedo.transactions.TransactionScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                onItemSelected = {
                    selectedIndex = it
                    println("++++++++++++++++++$selectedIndex")
                }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                println("++++++++++++++++++$selectedIndex")
                when (selectedIndex) {

                    // 0 -> HomeScreen()
                    //1 -> ()
                    2 -> TransactionScreen(rememberNavController())
                    // 3 -> SettingsScreen()
                    4 -> MoreScreen(rememberNavController())

                    else -> Text("Unknown Screen")
                }
            }

        }
    )
}

@Preview
@Composable
private fun BottomNavScreenPreview() {
    BottomNavScreen(rememberNavController())
}