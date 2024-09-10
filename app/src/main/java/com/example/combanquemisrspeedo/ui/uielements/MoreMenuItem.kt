package com.example.combanquemisrspeedo.ui.uielements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R


@Composable
fun MoreMenuItem(
    text: String,
    @DrawableRes startIcon: Int,
    @DrawableRes endIcon: Int? = null,
    onclick:() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(56.dp)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .clickable { onclick() }
    ) {
        Column {
            Icon(
                painter = painterResource(id = startIcon),
                contentDescription = null,
                tint = Color(0XFF7C7A78),
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
        Column {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0XFF7C7A78),
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            endIcon?.let {icon->
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = Color(0XFF7C7A78),
                    modifier = Modifier


                )
            }

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MoreMenuItemPreview() {
    MoreMenuItem(
        "Profile",
        R.drawable.user,
       // R.drawable.back_arrow
    ){}
}
