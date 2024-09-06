package com.example.combanquemisrspeedo.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.transactions.TransactionScreen
import com.example.combanquemisrspeedo.navigation.BottomNavigationBar
import com.example.combanquemisrspeedo.uielements.FavouriteListItem
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavController, modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            EditSheet()
        }
    }
    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it }
            )
        },
        content = {innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) { // Adjust the padding value as needed
                when (selectedIndex) {
                    // 0 -> HomeScreen()
                    //1 -> ()
                    2 -> TransactionScreen(rememberNavController())
                    // 3 -> SettingsScreen()
                    4-> MoreScreen(rememberNavController())
                    else -> Text("Unknown Screen")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding()
                    .systemBarsPadding(), // Handles padding for system bars
                contentAlignment = Alignment.TopCenter
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        //.padding(innerPadding)
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFFF8E7),
                                    P,
                                )
                            )
                        )
                        .padding(16.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.drop_down),
                                contentDescription = "Back",
                                modifier = Modifier
                                    //.align(Alignment.Start)
                                    .clickable {
                                        navController.popBackStack()
                                    }
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = modifier.weight(1f)
                        ) {
                            Text(
                                text = "Favourite",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.W500,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Your Favourite list",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        color = G900
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    FavouriteListItem(
                        name = "Asmaa Dosuky",
                        account = "xxxx7890",
                        editIcon = R.drawable.edit,
                        deleteIcon = R.drawable.delete,
                        onclickEdit = {
                            showBottomSheet = true
                        },
                        onclickDelete = {

                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    FavouriteListItem(
                        name = "Asmaa Dosuky",
                        account = "xxxx7890",
                        editIcon = R.drawable.edit,
                        deleteIcon = R.drawable.delete,
                        onclickEdit = {
                            showBottomSheet = true
                        },
                        onclickDelete = {
                            //only for test
                            navController.navigate(Route.MORESCREEN)}
                    )
                }
            }
        })
}


@Preview
@Composable
private fun FavouriteScreenPreview() {
    FavouriteScreen(rememberNavController())
}