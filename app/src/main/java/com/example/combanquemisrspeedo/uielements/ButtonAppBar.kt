package com.example.combanquemisrspeedo.uielements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.more.MoreScreen
import com.example.combanquemisrspeedo.navigation.Route
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.G200
import edu.android_security.ui.theme.P50


@Composable
fun BottomAppBar(
//    homeClick:() -> Unit,
//    transferClick:() -> Unit,
//    transactionClick:() -> Unit,
//    cardClick:() -> Unit,
//    moreClick:() -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(16.dp)
            .background(G0, RoundedCornerShape(24.dp)),
       horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                //homeClick
                {}
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "",
                    tint = G200
                )
            }
            Text(
                "Home",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = G200
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick =
            {}
            //transferClick
            )
            { Icon(painter = painterResource(id = R.drawable.transfer_1), contentDescription = "", tint = G200) }
            Text("Transfer",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = G200)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick =
            {}
            //transactionClick
            )
            { Icon(painter = painterResource(id = R.drawable.history_1), contentDescription = "", tint = G200) }
            Text("Transaction",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = G200)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick =
            //cardClick
            {}
            )
            { Icon(painter = painterResource(id = R.drawable.cards_1), contentDescription = "", tint = G200) }
            Text("My Cards",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = G200)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick =
            {}
            )
            { Icon(painter = painterResource(id = R.drawable.more), contentDescription = "", tint = G200) }
            Text("More",
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = G200)
        }
    }
}


@Preview
@Composable
private fun ButtonAppBarPreview() {
    BottomAppBar()

}