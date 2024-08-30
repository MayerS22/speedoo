package com.example.combanquemisrspeedo.uielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R

@Composable
fun TransferMessages(
    title: String,
    name: String,
    account: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(126.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF3E9EB))


    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .size(48.dp)
                .padding(start = 24.dp)

        ) {
                Icon(
                    painter = painterResource(id = R.drawable.bank),
                    contentDescription = "",
                    Modifier
                        .size(64.dp)
                )


        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(start = 32.dp)
        ) {
            Text(
                text = title,
                color = Color(0xFF871E35),
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                modifier = modifier.height(24.dp)
            )
            Text(
                text = name,
                color = Color(0xFF24221E),
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                modifier = modifier.padding(top = 4.dp)
            )
            Text(
                text = account,
                color = Color(0xFF898886),
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                modifier = modifier
                    .padding(top = 8.dp)
            )

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TransferMessagesPreview() {
    TransferMessages("From", "Asmaa Dosuky", "Account xxxx7890")
}