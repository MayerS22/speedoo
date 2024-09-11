package com.example.combanquemisrspeedo.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.ui.screens.main.card.CardsScreen
import com.example.combanquemisrspeedo.ui.screens.main.transactions.TransactionScreen
import com.example.combanquemisrspeedo.ui.screens.main.transfer.AmountScreen
import com.example.combanquemisrspeedo.ui.screens.main.transfer.HomeScreen
import com.example.combanquemisrspeedo.ui.screens.more.MoreScreen
import com.example.combanquemisrspeedo.ui.viewmodel.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavScreen(navController: NavController, userId: Long, modifier: Modifier = Modifier) {
    var selectedIndex by rememberSaveable  { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                onItemSelected = {
                    selectedIndex = it
                    println("++++++++++++++++++$selectedIndex")
                },
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {

                println("++++++++++++++++++$selectedIndex")
                when (selectedIndex) {

                    0 -> HomeScreen(navController,userId)
                    1 -> AmountScreen(navController)
                    2 -> TransactionScreen(navController)
                    3 -> CardsScreen(navController)
                    4 -> MoreScreen(navController)

                    else -> Text("Unknown Screen")
                }
            }
        }
    )
}
//@Preview
//@Composable
//private fun BottomNavScreenPreview() {
//    BottomNavScreen(rememberNavController())
//}