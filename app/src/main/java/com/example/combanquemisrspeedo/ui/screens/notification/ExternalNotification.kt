package com.example.combanquemisrspeedo.ui.screens.notification


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G40
import edu.android_security.ui.theme.G500
import edu.android_security.ui.theme.G700

@Composable
fun Notification(
    numOfNotification: Int,
    time: String,
    data: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(93.dp)
            .background(G0, RoundedCornerShape(16.dp))
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(56.dp)
                .background(G40, shape = CircleShape)
                .padding(8.dp)
        ) {

//            Image(
//                painter = painterResource(id = R.drawable.,
//                contentDescription = null,
//                modifier = Modifier.size(32.dp)
//            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$numOfNotification notification ",
                    color = G700,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = time,
                    color = G100,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    )
            }
            Text(
                text = data,
                color = G500,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }

}

@Preview
@Composable
private fun NotificationPreview() {
    Notification( 1,
        "12:00AM",
        "Lorem Ipsum is simply dummy ",


    )
}