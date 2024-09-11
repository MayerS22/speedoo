package com.example.combanquemisrspeedo.ui.screens.main.transactions

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G700
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50

@Composable
fun TransactionScreen(navController: NavController, modifier: Modifier = Modifier) {
    BackHandler {
        navController.popBackStack()
        //navController.navigate(Route.BOTTOMNAVSCREEN)
    }
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
                                .clickable {
                                    navController.popBackStack()
                                    //navController.navigate(Route.BOTTOMNAVSCREEN)
                                }
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            text = "Transactions",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500,
                            fontSize = 20.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Your Last Transactions",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = G900
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column {
                    PayCard(name = "Ahmed Mohamed",
                        cardNumber = "Visa . Mater Card . 1234",
                        timestamp ="Today 11:00 - Received" ,
                        amount = "\$1000",
                        status = "Successful",
                        )
                    Spacer(modifier = Modifier.height(16.dp))
                    PayCard(
                        name = "Khaled Hazem",
                        cardNumber = "Visa . Mater Card . 1234",
                        timestamp ="Today 1:00 - Received" ,
                        amount = "\$1000",
                        status = "Successful",
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    PayCard(
                        name = "Mayer Mohamed",
                        cardNumber = "Visa . Mater Card . 1234",
                        timestamp ="Last Week 11:00 - Received" ,
                        amount = "\$1000",
                        status = "Successful",
                    )
                }


            }
}

@Composable
fun PayCard(
        name: String,
        cardNumber: String,
        timestamp: String,
        status: String,
        amount: String
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(121.dp)
                .fillMaxSize()
                //.padding(16.dp),
            //elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .height(121.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier
                        .width(56.dp)
                        .height(54.dp)
                        .fillMaxWidth()
                        .background(Color.White),

                ) {
                    Box(modifier = Modifier
                        .width(56.dp)
                        .height(54.dp)
                        .fillMaxSize()
                        .background(
                            P50,
                            shape = RoundedCornerShape(8.dp)
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.card2),
                            contentDescription = "Credit Card",
                            tint = P300,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        modifier = Modifier.weight(1f), 
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = name,
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = G900
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = cardNumber,
                            fontWeight = FontWeight.W400,
                            fontSize = 12.sp,
                            color = G700
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = timestamp,
                            fontWeight = FontWeight.W400,
                            fontSize = 12.sp,
                            color = G100
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = amount,
                            fontWeight = FontWeight.W500,
                            fontSize = 16.sp,
                            color = P300
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEAF3EC), shape = CircleShape)
                        .width(71.dp)
                        .height(19.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = status,
                        fontWeight = FontWeight.W500,
                        fontSize = 9.sp,
                        color = Color(0xFF118A30),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }



@Composable
fun textFaildOrSucess(modifier: Modifier = Modifier) {
//if success-------

//    Box(
//        modifier = Modifier
//            .background(Color(0xFFEAF3EC), shape = CircleShape)
//            .width(71.dp)
//            .height(19.dp)
//            .align(Alignment.CenterVertically)
//    ) {
//        Text(
//            text = status,
//            fontWeight = FontWeight.W500,
//            fontSize = 9.sp,
//            color = Color(0xFF118A30),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
//    Spacer(modifier = Modifier.width(8.dp))
//}

//if faild-------

//    Box(
//        modifier = Modifier
//            .background(Color(0xFFFFEFEF), shape = CircleShape)
//            .width(71.dp)
//            .height(19.dp)
//            .align(Alignment.CenterVertically)
//    ) {
//        Text(
//            text = status,
//            fontWeight = FontWeight.W500,
//            fontSize = 9.sp,
//            color = Color(0xFFD80027),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
}



@Preview
@Composable
private fun TransactionScreenPreview() {
    TransactionScreen(rememberNavController())
}