package com.example.combanquemisrspeedo.ui.uielements



import androidx.compose.foundation.Image
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

@Composable
fun CardContent(label: String , name: String, account: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            //.padding(16.dp)
            .height(126.dp) // Increased height to make the card bigger
            .background(P50, RoundedCornerShape(8.dp)) // Light pink background
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(56.dp) // Increased size for the icon container
                .background(G40, shape = CircleShape) // Light gray background
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bank),
                contentDescription = null,
                modifier = Modifier.size(32.dp) // Increased icon size
            )
        }

        Spacer(modifier = Modifier.width(16.dp)) // Space between the icon and text

        Column(
            modifier = Modifier.weight(1f), // Ensure the column takes up available space
            verticalArrangement = Arrangement.Center // Center the text vertically within the column
        ) {
            Text(
                text = label,
                color = P300, // Dark red color for the "From" label
                fontSize = 16.sp,// Increased font size
                fontWeight = FontWeight.Medium,
//                fontFamily = FontFamily.Inter,
                modifier = Modifier.padding(bottom = 8.dp) // Space between label and name
            )
            Text(
                text = name,
                color = G900,
                fontSize = 20.sp, // Increased font size
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp) // Space between name and account
            )
            Text(
                text = "Account $account",
                color = G100,
                fontSize = 16.sp, // Increased font size
                fontWeight = FontWeight.Normal,
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview
@Composable
private fun CardContentPreview() {
    CardContent(label = "From", name = "Hazem", account = "01271169552")
}