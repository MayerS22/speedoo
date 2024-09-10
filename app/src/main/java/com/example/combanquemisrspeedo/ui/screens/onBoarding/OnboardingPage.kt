package com.example.combanquemisrspeedo.ui.screens.onBoarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import edu.android_security.ui.theme.G700
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPage(
    imageId: Int,
    title: String,
    description: String,
    pagerState: com.google.accompanist.pager.PagerState,
    onNextClick: () -> Unit // Callback for the button click
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Icon(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .height(303.dp)
                .width(350.dp)
                .padding(16.dp),
            tint = Color.Unspecified
        )

        // Dots indicator between the image and title
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = P300,
            inactiveColor = Color.Gray,
        )

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = G900
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            fontSize = 16.sp,
            color = G700,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(24.dp)) // Add space before the button

        SpeedoTextButton(
            text = "Next",
            textColor = Color.White,
            backgroundColor = P300,
            borderColor = Color.Transparent,
            //modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            onNextClick()
        }
    }
}
