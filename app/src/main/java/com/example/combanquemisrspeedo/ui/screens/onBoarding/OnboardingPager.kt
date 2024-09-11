package com.example.combanquemisrspeedo.ui.screens.onBoarding

import android.content.Context
import androidx.collection.emptyLongSet
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.model.OnboardingPageData
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(navController: NavController, context: Context) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    // List of onboarding pages
    val onboardingPages = listOf(
        OnboardingPageData(
            image = R.drawable.onboarding_image1,
            title = stringResource(id = R.string.amount),
            description = stringResource(id = R.string.amout_descip)
        ),
        OnboardingPageData(
            image = R.drawable.onboarding_image2,
            title = stringResource(id = R.string.confirmation),
            description = stringResource(id = R.string.confirmation_descrip)
        ),
        OnboardingPageData(
            image = R.drawable.onboarding_image3,
            title = stringResource(id = R.string.payment),
            description = stringResource(id = R.string.payment_descip)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Top Bar with "Skip" button
        TopAppBar(
            title = {},
            actions = {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Skip",
                        color = G900,
                        modifier = Modifier
                            .clickable(onClick = {
                                setOnboardingCompleted(context)
                                navController.popBackStack() // remove current item from history
                                navController.navigate(Route.SIGNUP)
                            })
                    )
                }
            },
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        )

        // Pager Content
        HorizontalPager(
            count = onboardingPages.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val pageData = onboardingPages[page]
            OnboardingPage(
                imageId = pageData.image,
                title = pageData.title,
                description = pageData.description,
                pagerState = pagerState,
                onNextClick = {
                    scope.launch {
                        if (pagerState.currentPage < onboardingPages.size - 1) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                        else{
                            setOnboardingCompleted(context)
                            navController.popBackStack()
                            navController.navigate(Route.SIGNUP)
                        }
                    }
                }

            )
        }
    }
}
fun setOnboardingCompleted(context: Context) {
    val prefs = context.getSharedPreferences("OnboardingPrefs", Context.MODE_PRIVATE)
    prefs.edit().putBoolean("onboardingCompleted", true).apply()
}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingPager() {
    OnboardingPager(rememberNavController(),LocalContext.current)
}