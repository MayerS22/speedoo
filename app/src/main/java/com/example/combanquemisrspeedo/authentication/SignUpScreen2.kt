package com.example.combanquemisrspeedo.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.Country
import com.example.combanquemisrspeedo.model.animateTranslation
import com.example.combanquemisrspeedo.navigation.AppNavHost
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.uielements.CountrySelector
import com.example.combanquemisrspeedo.uielements.DatePickerTextField
import com.example.combanquemisrspeedo.uielements.SignText
import com.example.combanquemisrspeedo.uielements.SpeedoTextButton
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen2(navController: NavController, modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    val countries = listOf(
        Country("United States", R.drawable.email),
        Country("Canada", R.drawable.email),
        Country("United Kingdom", R.drawable.email)
        // Add more countries as needed
    )

    var selectedCountry by remember { mutableStateOf<Country?>(null) }
    var dateOfBirth by remember { mutableStateOf("") }

    val isButtonEnabled = selectedCountry != null && dateOfBirth.isNotEmpty()
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)

    val interTextStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 29.sp,
        textAlign = TextAlign.Center
    )
    val interThinTextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 29.sp,
        textAlign = TextAlign.Center
    )

    // Show bottom sheet when the state is true
    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
//            scrimColor = Color.Transparent,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Set a fixed height for the dropdown
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                items(countries) { country ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedCountry = country
                                showBottomSheet = false
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
                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        White,
                        P,
                    )
                )
            )
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.drop_down),
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { navController.navigate(Route.SIGNUP) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Speedo Transfer",
            style = interTextStyle,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(66.dp))
        Text(
            text = "Welcome to Banque Misr!",
            style = interTextStyle,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Let’s Complete your Profile",
            style = interThinTextStyle,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        CountrySelector(
            labelText = "Country",
            placeholderText = "Select your country",
            countries = countries,
            onCountrySelected = { selectedCountry = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        DatePickerTextField(
            labelText = "Date Of Birth",
            placeholderText = "DD/MM/YYYY",
            trailingIcon = painterResource(id = R.drawable.date),
            onDateSelected = { dateOfBirth = it },
            modifier = Modifier.fillMaxWidth(),

        )
        Spacer(modifier = Modifier.height(32.dp))
        SpeedoTextButton(
            text = "Continue",
            textColor = White,
            backgroundColor = buttonColor,
            borderColor = buttonColor,
            modifier = Modifier.animateTranslation(scope)
        ) {
            if (isButtonEnabled) {
                navController.popBackStack()
                navController.navigate(Route.BOTTOMNAVSCREEN)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        SignText(
            firstText = stringResource(R.string.already_have_an_account),
            secondText = stringResource(R.string.sign_in),
            onSecondTextClick = { navController.navigate(Route.SIGNIN) }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignUpScreen2Preview() {
    SignUpScreen2(rememberNavController())
}
