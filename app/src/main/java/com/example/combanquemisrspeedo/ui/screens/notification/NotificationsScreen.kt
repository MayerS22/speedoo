package com.example.combanquemisrspeedo.ui.screens.notification

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import com.example.combanquemisrspeedo.ui.screens.more.MoreScreen
import com.example.combanquemisrspeedo.ui.screens.main.transactions.TransactionScreen
import com.example.combanquemisrspeedo.navigation.BottomNavigationBar
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G700
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P50

@Composable
fun NotificationsScreen(navController: NavController,modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }

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
                                //.align(Alignment.Start)
                                .clickable {
                                    //navigation
                                }
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            text = "Notifications",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500,
                            fontSize = 20.sp
                        )
                    }

                }
                Spacer(modifier = Modifier.height(30.dp))

                   Column {
                       NotifcationCard()
                       Spacer(modifier = Modifier.height(16.dp))
                       NotifcationCard()
                       Spacer(modifier = Modifier.height(16.dp))
                       NotifcationCard()
                   }


            }
        }

@Composable
fun NotifcationCard(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(107.dp)
            //.padding(horizontal = 8.dp, vertical = 14.dp)
            .background(P50, RoundedCornerShape(8.dp))
            .shadow(
                elevation =1.dp,
                shape = RoundedCornerShape(4.dp),
                spotColor = Color.LightGray
            )
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = modifier.width(56.dp)
                .height(54.dp)
                .background(P50, RoundedCornerShape(8.dp))
                .shadow(
                    elevation =1.dp,
                    shape = RoundedCornerShape(4.dp),
                    spotColor = Color.LightGray
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.group_18327),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Receive Transaction",
               fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                color = G900
                )
            Text(text = "You have received 1000 USD from Asmaa Dosuky 1234 xxx",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                color = G700
                )
            Text(text = "12 Jul 2024 09:00 PM",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                color = G100
                )
        }
        }


    }


@Preview
@Composable
private fun NotificationsScreenPreview() {
   NotificationsScreen(rememberNavController())
  //  NotifcationCard()
}