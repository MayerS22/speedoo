package com.example.combanquemisrspeedo.ui.screens.main.card

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G30
import edu.android_security.ui.theme.G40
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50

@Composable
fun CardsScreen(navController: NavController, modifier: Modifier = Modifier) {
    BackHandler {
        navController.popBackStack()
        navController.navigate(Route.BOTTOMNAVSCREEN)
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
                        text = "My Cards",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
            Item(
                name = "Asmaa Dosuky",
                account = "xxxx7890",
                )
            Spacer(modifier = Modifier.height(40.dp))
            SpeedoTextButton(
                text = "Add New Account",
                borderColor = P300,
                backgroundColor = P300,
                textColor = Color.White
            )
            { }
        }
    }
}



@Composable
fun Item(
    name: String,
    account: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(P50, RoundedCornerShape(8.dp))
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(56.dp)
                .background(G40, shape = CircleShape)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bank),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                color = G900,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Account $account",
                color = G100,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
            )
        }

            Box(
                modifier = Modifier
                    .background(G30, shape = CircleShape)
                    .width(70.dp)
                    .height(24.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Default",
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    color = G100,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
        }


        }

        Spacer(modifier = Modifier.width(16.dp))

        }



@Preview
@Composable
private fun CardsScreenPreview() {
    CardsScreen(rememberNavController())
}