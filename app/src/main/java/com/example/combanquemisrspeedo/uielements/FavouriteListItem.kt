import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

// Data model representing a favorite item
data class FavouriteItem(
    val id: Int,
    val name: String,
    val account: String
)

// Composable to display an individual favorite item
@Composable
fun FavouriteListItem(
    name: String,
    account: String,
    @DrawableRes editIcon: Int? = null,
    @DrawableRes deleteIcon: Int? = null,
    modifier: Modifier = Modifier,
    onclickEdit: () -> Unit,
    onclickDelete: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
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
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Account $account",
                color = G100,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
            )
        }

        editIcon?.let { icon ->
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = G100,
                modifier = modifier.clickable { onclickEdit() }
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        deleteIcon?.let { icon ->
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = D300,
                modifier = modifier.clickable { onclickDelete() }
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
}

// Composable to manage the list of favorite items and render them
@Composable
fun FavouriteListScreen(
    onclickEdit: () -> Unit,
) {
    var favouriteItems by remember { mutableStateOf(
        listOf(
            FavouriteItem(1, "Asmaa Dosuky", "xxxx7890"),
            FavouriteItem(2, "Asmaa Dosuky", "22xxxx789022")
        )
    ) }

    Column {
        favouriteItems.forEach { item ->
            FavouriteListItem(
                name = item.name,
                account = item.account,
                editIcon = R.drawable.edit,
                deleteIcon = R.drawable.delete,
                onclickEdit = { onclickEdit() },
                onclickDelete = {
                    favouriteItems = favouriteItems.filterNot { it.id == item.id }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun FavouriteListScreenPreview() {
    FavouriteListScreen(){

    }
}
