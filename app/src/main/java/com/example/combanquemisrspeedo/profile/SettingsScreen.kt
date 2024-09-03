package com.example.combanquemisrspeedo.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.uielements.SpeedoTextField
import edu.android_security.ui.theme.G100
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P
import edu.android_security.ui.theme.P50
import edu.android_security.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.settings),
                        fontSize = 20.sp,
                        color = G900,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
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
                SettingsItem(
                    icon = R.drawable.lock,
                    title = stringResource(id = R.string.change_password),
                    description = stringResource(id = R.string.change_password),
                            onClick = {
                        // Handle click on the entire item
                    },
                    onArrowClick = {
                        // Handle arrow button click to navigate to another page
                    }
                )
                SettingsItem(
                    icon = R.drawable.rededit,
                    title = stringResource(id = R.string.edit_profile),
                    description = stringResource(R.string.change_your_information),
                    onClick = {

                    },
                    onArrowClick = {

                    }
                )

            }
        }
    )
}
@Composable
fun SettingsItem(
    icon: Int,
    title: String,
    description: String,
    onClick: () -> Unit,
    onArrowClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(P50),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)

            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                color = G900,
                fontSize = 16.sp,
                text = title,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = description,
                color = G100,
                fontSize = 16.sp,
            )
        }

        IconButton(
            onClick = onArrowClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Navigate"
            )
        }
    }
}


@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen(onBackClick = {})
}