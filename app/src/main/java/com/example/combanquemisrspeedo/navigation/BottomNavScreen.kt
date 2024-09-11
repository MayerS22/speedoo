package com.example.combanquemisrspeedo.navigation

import android.annotation.SuppressLint
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
fun BottomNavScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel : HomeViewModel = viewModel()
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    val accountId by viewModel.accountId.collectAsState() // Use collectAsState for StateFlow

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    // Handle navigation based on selectedIndex
                    when (index) {
                        0 -> {
                            navController.navigate("${Route.HOMESCREEN}/${accountId ?: 0}")
                        }
                        1 -> navController.navigate(Route.AMOUNTSCREEN)
                        2 -> navController.navigate(Route.TRANSACTIONSCREEN)
                        3 -> navController.navigate(Route.CARDSSCREEN)
                        4 -> navController.navigate(Route.MORESCREEN)
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (selectedIndex) {
                    0 -> HomeScreen(navController, accountId) // Correct parameter usage
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


@Preview
@Composable
private fun BottomNavScreenPreview() {
    BottomNavScreen(rememberNavController())
}