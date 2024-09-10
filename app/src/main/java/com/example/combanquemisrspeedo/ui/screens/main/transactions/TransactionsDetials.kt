package com.example.combanquemisrspeedo.ui.screens.main.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.ui.screens.more.MoreScreen
import com.example.combanquemisrspeedo.navigation.BottomNavigationBar
import com.example.combanquemisrspeedo.ui.uielements.SuccessCardWithIcon
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G700
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50

@Composable
fun TransactionsDetails(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }
    Column(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF8E7),
                        P,
                    )
                )
            )
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
            modifier = modifier
                //.background(Color.Transparent)
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
                    //.background(Color.Transparent)
            ) {
                Text(
                    text = "Successful Transactions",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp
                ) } }
        Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(22.dp)
                        .background(Color.Transparent)
                ) {
                    Image(painter = painterResource(id=R.drawable.group_18305),
                        contentDescription = ""
                    )
                    Spacer(modifier = modifier.height(14.dp))
                    Text(text = "1000 USD",
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Send money",
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = G700
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Received money",
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = P300
                    )

                    //Spacer(modifier = modifier.height(10.dp))
                    SuccessCardWithIcon("Dina", "123456789", "Ahmed", "987654321")
                    DataTransferDetails()
                }
}}

@Composable
fun DataTransferDetails(modifier: Modifier = Modifier) {
    Row(
        //verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(162.dp)
            .background(P50, RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = modifier.height(30.dp))
            Row(
                //verticalAlignment = Alignment.CenterHorizontally,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text("Transfer amount amount",
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = G700
                )
                Text("48.4220 EGP",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = G100
                )
            }
            Spacer(modifier = modifier.height(20.dp))
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 0.5.dp,
                modifier = modifier.padding(horizontal = 14.dp)
            )
            Spacer(modifier = modifier.height(20.dp))
            Row(
                //verticalAlignment = Alignment.CenterHorizontally,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text("Reference",
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = G700
                )
                Text("123456789876",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = G100
                )
            }
            Spacer(modifier = modifier.height(14.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text("Date",
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = G700
                )
                Text("20 Jul 2024 7:50 PM",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = G100
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SuccessfulTransactionsPreview() {
    TransactionsDetails()
}