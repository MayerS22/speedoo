package com.example.combanquemisrspeedo.authentication

import android.icu.text.SimpleDateFormat
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
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

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
    )

    var selectedCountry by remember { mutableStateOf<Country?>(null) }
    var dateOfBirth by remember { mutableStateOf("") }
    var dateErrorMessage by remember { mutableStateOf("") }

    val isButtonEnabled = selectedCountry != null && dateOfBirth.isNotEmpty() && dateErrorMessage.isEmpty()
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

    // Bottom sheet logic
    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = {
                scope.launch { sheetState.hide() }
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                items(countries) { country ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedCountry = country
                                scope.launch { sheetState.hide() }
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
            onDateSelected = { date ->
                // Ensure the user is at least 18 years old
                val isValidAge = checkIfAgeIsValid(date, 18)
                if (isValidAge) {
                    dateOfBirth = date
                    dateErrorMessage = ""
                } else {
                    dateErrorMessage = "You must be at least 18 years old."
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )
        if (dateErrorMessage.isNotEmpty()) {
            Text(
                text = dateErrorMessage,
                color = Color.Red,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        SpeedoTextButton(
            text = "Continue",
            textColor = White,
            backgroundColor = buttonColor,
            borderColor = buttonColor,
            modifier = Modifier
                .fillMaxWidth()
                .animateTranslation(scope)
        ) {
            if (isButtonEnabled) {
                //Only for testing-------
                navController.navigate(Route.PROFILE)
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

// Helper function to check if the user is at least a specific age
fun checkIfAgeIsValid(date: String, minAge: Int): Boolean {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val birthDate = formatter.parse(date)
    val currentCalendar = Calendar.getInstance()

    val age = currentCalendar.get(Calendar.YEAR) - birthDate.year
    return age >= minAge
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignUpScreen2Preview() {
    SignUpScreen2(rememberNavController())
}
