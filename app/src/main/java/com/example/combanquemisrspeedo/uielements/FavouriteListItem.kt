package com.example.combanquemisrspeedo.uielements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import edu.android_security.ui.theme.D300
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G40
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P50

@Composable
fun FavouriteListItem(
    name: String,
    account: String,
    @DrawableRes editIcon: Int? = null,
    @DrawableRes deleteIcon: Int? = null,
    modifier: Modifier = Modifier,
    onclickEdit:() -> Unit,
    onclickDelete: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(100.dp)
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
        editIcon?.let {icon->
        Icon(
            painter = painterResource(id = editIcon),
            contentDescription = "",
            tint = Color.DarkGray,
            modifier = modifier.clickable { onclickEdit() }
        )}

        Spacer(modifier = Modifier.width(16.dp))

        deleteIcon?.let {icon->
        Icon(
            painter = painterResource(id = deleteIcon),
            contentDescription = "",
            tint = D300,
            modifier = modifier.clickable { onclickDelete() }
        )}

        Spacer(modifier = Modifier.width(16.dp))
    }

}

@Preview
@Composable
private fun FavouriteListItemPreview() {
    FavouriteListItem( "Dina",
        "1111",
        R.drawable.edit,
        R.drawable.delete,
        onclickDelete = {},
        onclickEdit = {}
        )
}