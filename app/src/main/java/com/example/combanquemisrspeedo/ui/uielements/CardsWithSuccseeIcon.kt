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
fun SuccessCardWithIcon(
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
                painter = painterResource(id = R.drawable.sucsses),
                contentDescription = "Swap Icon",
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp)
            )
        }
    }
}


@Preview(showSystemUi = false, showBackground = false)
@Composable
private fun SuccessCardWithIconPreview() {
    SuccessCardWithIcon("Dina", "123456789", "Ahmed", "987654321")
}