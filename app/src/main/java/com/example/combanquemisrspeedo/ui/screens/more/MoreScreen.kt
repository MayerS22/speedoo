package com.example.combanquemisrspeedo.ui.screens.more

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
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
import com.example.combanquemisrspeedo.ui.uielements.MoreMenuItem
import edu.android_security.ui.theme.P


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController, modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    BackHandler {
        navController.popBackStack()
        navController.navigate(Route.BOTTOMNAVSCREEN)
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            HelpSheet()
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding()  //RoundCorner??
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
                        .clickable {
                            navController.popBackStack()
                            navController.navigate(Route.BOTTOMNAVSCREEN)
                        }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "More",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        MoreMenuItem("Transfer From Website", R.drawable.website, R.drawable.arrow_right)
        { }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.LightGray
        )
        MoreMenuItem("Favorite", R.drawable.favorite, R.drawable.arrow_right)
        {
            navController.navigate(Route.FAVOURITESCREEN)
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.LightGray
        )
        MoreMenuItem("Profile", R.drawable.user, R.drawable.arrow_right)
        {
            navController.navigate(Route.PROFILE)
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.LightGray
        )
        MoreMenuItem("Help", R.drawable.fill, R.drawable.arrow_right)
        { showBottomSheet = true }
        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.LightGray
        )
        MoreMenuItem("Logout", R.drawable.logout)
        {
            navController.popBackStack()
            navController.navigate(Route.SIGNIN)
        }
        Spacer(modifier = Modifier.height(100.dp))
    }

}




@Preview
@Composable
private fun MoreScreenPreview() {
    MoreScreen(rememberNavController())
}