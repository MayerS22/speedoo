package com.example.combanquemisrspeedo.transactions

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
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
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.uielements.BottomAppBar
import com.example.combanquemisrspeedo.uielements.CardContent
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G700
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50

@Composable
fun TransactionsDetails(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { BottomAppBar() },
        content = { innerPadding ->
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
                Spacer(modifier = Modifier.height(10.dp))
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
                            text = "Successful Transactions",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W500,
                            fontSize = 20.sp
                        )
                    }

                }
                Spacer(modifier = Modifier.height(32.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxSize()
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

                    Text(text = "Transfer amount",
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

                    Spacer(modifier = modifier.height(10.dp))

                    //change---

                    CardContent(
                        label = "From",
                        name = "Asmaa Dosuky",
                        account = "Account xxxx7890"
                    )
                    CardContent(
                        label = "From",
                        name = "Asmaa Dosuky",
                        account = "Account xxxx7890"
                    )
                    DataTransferDetails()
                }
            }
        }
    )
}

@Composable
fun DataTransferDetails(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(343.dp)
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
                modifier = modifier.fillMaxWidth()
                    .padding(horizontal =  32.dp)
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
                modifier = modifier.fillMaxWidth()
                    .padding(horizontal =  32.dp)
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
                modifier = modifier.fillMaxWidth()
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

@Preview
@Composable
private fun SuccessfulTransactionsPreview() {
    TransactionsDetails()
}