package com.example.combanquemisrspeedo.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.combanquemisrspeedo.ui.uielements.SettingsItem
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.profile),
                        fontSize = 20.sp,
                        color = G900,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.navigate(Route.MORESCREEN)
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
                Row(
                    Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)

                            .clip(RoundedCornerShape(30.dp))
                            .background(P50),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = "AD",
                            fontSize = 20.sp,
                            color = G100,
                            fontWeight = FontWeight.Bold,


                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Text(
                        text = "Asmaa Dosuky",
                        fontSize = 20.sp,
                        color = G900,
                        fontWeight = FontWeight.Bold,

                    )

                }
                Spacer(modifier = Modifier.size(35.dp))
                SettingsItem(
                    icon = R.drawable.user2,
                    title = stringResource(id = R.string.profile_information),
                    description = stringResource(R.string.your_information),
                    onClick = {
                        navController.navigate(Route.PROFILEINFO)
                    },
                    onArrowClick = {
                        navController.navigate(Route.PROFILEINFO)
                    }
                )

                HorizontalDivider(Modifier.padding(5.dp))
                SettingsItem(
                    icon = R.drawable.setting2,
                    title = stringResource(R.string.setting),
                    description = stringResource(R.string.change_your_settings),
                    onClick = {
                        navController.navigate(Route.SETTING)
                    },
                    onArrowClick = {
                        navController.navigate(Route.SETTING)
                    }
                )

                HorizontalDivider(Modifier.padding(5.dp))
                SettingsItem(
                    icon = R.drawable.history_2,
                    title = stringResource(R.string.payment_history),
                    description = stringResource(R.string.view_your_transactions),
                    onClick = {
                        navController.navigate(Route.TRANSACTIONSCREEN)
                    },
                    onArrowClick = {
                        navController.navigate(Route.TRANSACTIONSCREEN)
                    }
                )

                HorizontalDivider(Modifier.padding(5.dp))
                SettingsItem(
                    icon = R.drawable.favorite2,
                    title = stringResource(R.string.my_favorite_list),
                    description = stringResource(R.string.view_your_favourites),
                    onClick = {
                       navController.navigate(Route.FAVOURITESCREEN)
                    },
                    onArrowClick = {
                        navController.navigate(Route.FAVOURITESCREEN)
                    }
                )

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen (rememberNavController())
}