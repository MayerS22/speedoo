package com.example.combanquemisrspeedo.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.G40
import edu.android_security.ui.theme.G500

@Composable
fun CustomSnackBar(
    snackbarData: SnackbarData,
    onDismiss: () -> Unit,
)

{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(82.94.dp)
            // .padding(8.dp)
            .background(
                G40, RoundedCornerShape(4.42.dp)
            )
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .width(26.54.dp)
                .height(26.54.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.group_9),
                contentDescription = "",
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier.width(229.53.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "We Logged you out because you were inactive for 2 minutes - it’s to help your account secure ",
                color = G500,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .width(26.54.dp)
                .height(26.54.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.clickable {
                    onDismiss()
                }
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

