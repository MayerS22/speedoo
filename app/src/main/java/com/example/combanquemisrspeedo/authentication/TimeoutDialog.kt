package com.example.combanquemisrspeedo.Authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R

@Composable
fun TimeoutDialog(onDismiss: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFD3D3D3)) // Gray color
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Exclamation Icon
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.warning), // Replace with your warning icon
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)

                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Message Text
                Text(
                    text = stringResource(R.string.you_logged_out),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Close Icon
            Icon(
                painter = painterResource(id = R.drawable.close), // Replace with your close icon
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp) // Increase the size slightly
                    .clickable { onDismiss() }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TimeoutDialogPreview() {
    TimeoutDialog(onDismiss = {})
}
