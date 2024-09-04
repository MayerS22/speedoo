package com.example.combanquemisrspeedo.notification

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
import edu.android_security.ui.theme.P

@Composable
fun NotificationsScreen(modifier: Modifier = Modifier) {
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
                Spacer(modifier = Modifier.height(16.dp))
               Row {
                   Column {

                   }
                   Column {  }
               }
            }
        }
    )
}


@Preview
@Composable
private fun NotificationsScreenPreview() {
    NotificationsScreen()
}