package com.example.combanquemisrspeedo.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import edu.android_security.ui.theme.G0
import edu.android_security.ui.theme.G200
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300

@Composable
fun BottomNavigationBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(P)
            .shadow(0.5.dp, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        backgroundColor = G0,
        //elevation = 10.dp
    ) {
        val items = listOf(
            NavigationItem(icon = R.drawable.home, label = "Home"),
            NavigationItem(icon = R.drawable.transfer_1, label = "Transfer"),
            NavigationItem(icon = R.drawable.history_1, label = "Transaction"),
            NavigationItem(icon = R.drawable.cards_1, label = "My Cards"),
            NavigationItem(icon = R.drawable.more, label = "More")
        )

        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                modifier = Modifier
                    .background(G0),
                icon = {
                    Icon(
                        modifier = Modifier.height(30.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (index == selectedIndex) P300 else G200,
                    )
                },
                label = {
                    Text(
                        item.label,
                        fontSize = 9.sp,
                        color = if (index == selectedIndex) P300 else G200
                    )
                },
                selected = index == selectedIndex,
                onClick = {
                    onItemSelected(index)
                    println("Item clicked: $index")

                }
            )
        }
    }
}

//@Preview
//@Composable
//private fun BottomNavScreenPreview() {
//    BottomNavScreen(rememberNavController())
//}