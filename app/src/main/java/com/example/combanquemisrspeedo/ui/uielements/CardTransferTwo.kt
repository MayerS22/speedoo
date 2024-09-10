package com.example.combanquemisrspeedo.ui.uielements


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G40
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.P50
import edu.android_security.ui.theme.P500

@Composable
fun TransactionCardWithIcon(
    fromName: String,
    fromAccount: String,
    toName: String,
    toAccount: String,
) {
    Box {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            CardContent(
           label = "From",
                name = fromName,
            account = fromAccount
      )
            CardContent(
                label = "To",
                name = toName,
                account = toAccount
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.height(250.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.transfer),
                contentDescription = "Swap Icon",
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp)
            )
        }
    }
}
@Composable
fun CardContent(label: String, name: String, account: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding( vertical = 8.dp)
            .height(126.dp)
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
                text = label,
                color = P300,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = name,
                color = G900,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Account $account",
                color = G100,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = false)
@Composable
private fun TransferCardPreview() {
    TransactionCardWithIcon("Dina", "123456789", "Ahmed", "987654321")
}