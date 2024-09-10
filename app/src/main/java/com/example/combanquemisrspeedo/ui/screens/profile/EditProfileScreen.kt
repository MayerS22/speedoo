package com.example.combanquemisrspeedo.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.Country
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.ui.uielements.CountrySelector
import com.example.combanquemisrspeedo.ui.uielements.DatePickerTextField
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile(navController: NavController) {


    val countries = listOf(
        Country("United States", R.drawable.email),
        Country("Canada", R.drawable.email),
        Country("United Kingdom", R.drawable.email)
    )

    var selectedCountry by remember { mutableStateOf<Country?>(null) }
    var dateOfBirth by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf<String?>(null) }
    val hasTypedEmail = remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }



    val isButtonEnabled = fullName.isNotEmpty() && email.isNotEmpty() && selectedCountry != null && dateOfBirth.isNotEmpty()
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)
    Scaffold(
        modifier = Modifier
            .padding(top = 20.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF8E7),
                        Color(0xFFFFEAEE),
                    )
                )
            ),

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.edit_profile),
                        fontSize = 20.sp,
                        color = G900,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.navigate(Route.SETTING)
                        navController.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        content = { paddingValues ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)

            ) {
                Spacer(modifier = Modifier.size(35.dp))
                SpeedoTextField(
                    labelText = stringResource(id = R.string.full_name),
                    placeholderText = stringResource(R.string.enter_cardholder_name),
                    onTextChange = { fullName = it },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                SpeedoTextField(
                    labelText = stringResource(id = R.string.email),
                    placeholderText = stringResource(R.string.enter_cardholder_email),
                    onTextChange =
                    {
                        email = it
                        hasTypedEmail.value = true
                        emailError.value = validateEmail(it)
                    },
                    keyboardType = KeyboardType.Email,
                    errorMessage = if (hasTypedEmail.value) emailError.value else null,
                    errorColor = if (hasTypedEmail.value) Color.Red else Color.Transparent,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                CountrySelector(
                    labelText = stringResource(R.string.country),
                    placeholderText = stringResource(R.string.select_your_country),
                    countries = countries,
                    onCountrySelected = { selectedCountry = it },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                DatePickerTextField(
                    labelText = stringResource(R.string.date_of_brith),
                    placeholderText = "DD/MM/YYYY",
                    trailingIcon = painterResource(id = R.drawable.date),
                    onDateSelected = { dateOfBirth = it },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(25.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 23.dp, end = 16.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    SpeedoTextButton(
                        text = stringResource(R.string.save),
                        textColor = White,
                        backgroundColor = buttonColor,
                        borderColor = buttonColor
                    ) {
                        if (isButtonEnabled) {
                            // Handle sign-in logic here
                        }
                    }
                }

            }
        }
    )

}

fun validateEmail(email: String): String? {
    return if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        "Invalid email address"
    } else {
        null
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditProfile(rememberNavController())
}
