package com.example.combanquemisrspeedo.more

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50

@Composable
fun HelpSheet(modifier: Modifier = Modifier) {
    Column(
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                ContactOption(
                    iconRes = R.drawable.outline_email_24,
                    text = "Send Email",
                    onClick = { /* Handle Send Email click */ }
                )
            }
            Spacer(modifier = Modifier.width(13.dp))
            Column(
                modifier = modifier.weight(1f)
            ) {
                ContactOption(
                    iconRes = R.drawable.call,
                    text = "Call Us\n000000",
                    onClick = { /* Handle Call Us click */ }
                )
            }
        }
        Spacer(modifier = Modifier.height(60.dp))
    }
    }


@Composable
fun ContactOption(iconRes: Int, text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .shadow(8.dp, RoundedCornerShape(8.dp))
            .background(Color.White)
            //.weight(1f)
            .clickable { onClick }
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                //.weight(1f)
                .size(width = 140.dp, height = 120.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box (
                modifier = Modifier
                    .shadow(0.dp, RoundedCornerShape(6.dp))
                    .background(P50)
                    .width(55.dp)
                    .height(55.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(0.dp, RoundedCornerShape(6.dp))
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = null,
                        tint = P300,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = G900,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun HelpSheetPrev() {
    HelpSheet()
}
