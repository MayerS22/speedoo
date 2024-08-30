package com.example.combanquemisrspeedo.uielements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.Country
import edu.android_security.ui.theme.G50


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

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = labelText,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = selectedCountry?.name ?: "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .clickable { expanded = !expanded },
            shape = RoundedCornerShape(6.dp),
            placeholder = { Text(text = placeholderText) },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = if (expanded) R.drawable.chevron_down else R.drawable.chevron_down), // Replace with your arrow icons
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(G50)
        ) {
            countries.forEach { country ->
                DropdownMenuItem(
                    onClick = {
                        selectedCountry = country
                        expanded = false
                        onCountrySelected(country)
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = country.flagResId),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    text = {
                        Text(text = country.name)
                    }
                )
            }
        }
    }
}
