package com.example.combanquemisrspeedo.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.ui.uielements.ProfileInfoItem
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileInformationScreen(navController: NavController) {

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.profile_information),
                            fontSize = 20.sp,
                            color = G900,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                               navController.navigate(Route.PROFILE)
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
                    modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFFF8E7),
                                    Color(0xFFFFEAEE),
                                )
                            )
                        )
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.size(35.dp))
                    ProfileInfoItem(label = "Full Name", value = "Asmaa Dosuky")
                    HorizontalDivider()
                    ProfileInfoItem(label = "Email", value = "Asmaa@gmail.com")
                    HorizontalDivider()
                    ProfileInfoItem(label = "Date Of Birth", value = "12/01/2000")
                    HorizontalDivider()
                    ProfileInfoItem(label = "Country", value = "Egypt")
                    HorizontalDivider()
                    ProfileInfoItem(label = "Bank Account", value = "1234xxxx")
                }
            }
        )
    }


@Preview(showBackground = true)
@Composable
private fun ProfileInformationScreenPreview() {
    ProfileInformationScreen(rememberNavController())
}
