package com.example.combanquemisrspeedo.uielements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.Country
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P50
import edu.android_security.ui.theme.P75
import edu.android_security.ui.theme.White

@Composable
fun CountrySelector(
    labelText: String,
    placeholderText: String,
    countries: List<Country>,
    onCountrySelected: (Country) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf<Country?>(null) }
    val dropdownHeight = 200.dp // Set a fixed height for the dropdown
    val borderColor = Color.Gray
    val textColor = Color.Black
    val placeholderColor = Color.Gray
    val backgroundColor = White

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = labelText,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .background(Color.Transparent) // Ensure the clickable area is transparent
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, borderColor, RoundedCornerShape(6.dp))
                    .background(backgroundColor, RoundedCornerShape(6.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = selectedCountry?.name ?: placeholderText,
                    color = if (selectedCountry == null) placeholderColor else textColor,
                    style = TextStyle(fontSize = 16.sp)
                )
                Icon(
                    painter = painterResource(id = if (expanded) R.drawable.chevron_down else R.drawable.drop_down),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterEnd)
                )
            }
        }

        if (expanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dropdownHeight) // Fixed height for dropdown
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize() // Ensure LazyColumn fills the Box
                ) {
                    items(countries) { country ->
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedCountry = country
                                        onCountrySelected(country)
                                        expanded = false
                                    }
                                    .padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = country.flagResId),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = country.name)
                            }
//                            Divider(
//                                color = Color.Gray,
//                                thickness = 1.dp,
//                                modifier = Modifier.padding(horizontal = 8.dp)
//                            )
                        }
                    }
                }
            }
        }
    }
}
