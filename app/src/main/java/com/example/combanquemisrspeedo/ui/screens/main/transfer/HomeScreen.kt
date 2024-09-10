package com.example.combanquemisrspeedo.ui.screens.main.transfer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G200
import edu.android_security.ui.theme.G40
import edu.android_security.ui.theme.G50
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF8E7),
                        Color(0xFFFFEAEE),
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar and Welcome Texts
                Row(
                    modifier = Modifier
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(P50),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "AD",
                            fontSize = 20.sp,
                            color = G100,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "Welcome back,",
                            fontSize = 14.sp,
                            color = P300
                        )

                        Text(
                            text = "Asmaa Dosuky",
                            fontSize = 16.sp,
                            color = G900
                        )
                    }
                }


                Icon(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "Notifications Icon",
                    tint = G900, // Icon color
                    modifier = Modifier
                        .height(32.dp)
                        .width(32.dp)
                        .padding(end = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = P300
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Current Balance",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "10000EGP",
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Recent Transactions Heading
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.recent_transactions),
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = 16.sp,
                    color = G900
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {  }) {
                    Text(
                        text = "View all",
                        color = G200,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()

            ) {
                items(transactionsList) { transaction ->
                    Column {
                        TransactionItem(
                            name = transaction.name,
                            amount = transaction.amount,
                            date = transaction.date,
                            time = transaction.time,
                            type = transaction.type
                        )
                        HorizontalDivider(

                            color = G40
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionItem(name: String, amount: String, date: String, time: String, type: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(G0),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Transaction Icon Box
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = P50),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.mastercard),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(18.dp),
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Transaction Details
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Text(
                        text = "$date, $time",
                        fontSize = 12.sp,
                        color = Color(0xFF757575)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = type,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (type == "Sent") Color(0xFFB71C1C) else Color(0xFF4CAF50) // Red for Sent, Green for Received
                    )
                }
            }

            // Transaction Amount
            Text(
                text = amount,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB71C1C)
            )
        }
    }
}


// Updated Transaction data model to include time and transaction type
data class Transaction(
    val name: String,
    val amount: String,
    val date: String,
    val time: String,
    val type: String
)

// Example of a list of transactions
val transactionsList = listOf(
    Transaction("Ahmed Mohamed", "500 EGP", "Yesterday", "12:30 PM", "Received"),
    Transaction("Ahmed Mohamed", "500 EGP", "Today", "9:45 AM", "Sent"),
    Transaction("Ahmed Mohamed", "500 EGP", "Today", "11:15 AM", "Sent"),
    Transaction("Ahmed Mohamed", "500 EGP", "Today", "1:00 PM", "Received"),
    Transaction("Ahmed Mohamed", "500 EGP", "Today", "2:45 PM", "Received")
)

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    HomeScreen(rememberNavController())
}
