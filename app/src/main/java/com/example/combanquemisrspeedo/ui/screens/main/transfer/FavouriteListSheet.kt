package com.example.combanquemisrspeedo.ui.screens.main.transfer


import FavouriteListItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@Composable
fun FavouriteListSheet(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(515.dp)
            .padding(16.dp)
            .padding(bottom = 100.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.favorite),
                contentDescription = "",
                tint = P300
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Favorite",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        FavouriteListItem(
            name = "Asmaa Dosuky",
            account = "xxxx7890",
            onclickDelete = {},
            onclickEdit = {}
        )
        Spacer(modifier = Modifier.height(10.dp))
        FavouriteListItem(
            name = "Asmaa Dosuky",
            account = "xxxx7890",
            onclickDelete = {},
            onclickEdit = {}
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun FavouriteListSheetPreview() {
    FavouriteListSheet()
}