package com.example.combanquemisrspeedo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.authentication.SignInAgain
import com.example.combanquemisrspeedo.authentication.SignInScreen
import com.example.combanquemisrspeedo.authentication.SignUpScreen1
import com.example.combanquemisrspeedo.authentication.SignUpScreen2
import com.example.combanquemisrspeedo.authentication.SplashScreen
import com.example.combanquemisrspeedo.card.CardsScreen
import com.example.combanquemisrspeedo.model.CustomSnackBar
import com.example.combanquemisrspeedo.more.FavouriteScreen
import com.example.combanquemisrspeedo.more.MoreScreen
import com.example.combanquemisrspeedo.onBoarding.OnboardingPager
import com.example.combanquemisrspeedo.profile.ChangePassword
import com.example.combanquemisrspeedo.profile.EditProfile
import com.example.combanquemisrspeedo.profile.ProfileInformationScreen
import com.example.combanquemisrspeedo.profile.ProfileScreen
import com.example.combanquemisrspeedo.profile.SettingsScreen
import com.example.combanquemisrspeedo.transactions.TransactionScreen
import com.example.combanquemisrspeedo.transfer.HomeScreen

object Route {
    const val START= "splash"
    const val SIGNUP="signUp"
    const val SIGNUP2="signUp2"
    const val SIGNIN="signIn"
    const val SIGNINADAIN="signInAgain"
    const val PROFILE="Profile"
    const val PROFILEINFO="ProfileInfo"
    const val EDITPROFILE="EditProfile"
    const val SETTING="Setting"
    const val CHANGPASS="ChangePass"
    const val FAVOURITESCREEN="FavouriteScreen"
    const val MORESCREEN="MoreScreen"
    const val TRANSACTIONSCREEN="TransactionScreen"
    const val BOTTOMNAVSCREEN="BottomNavScreen"
    const val CARDSSCREEN="CardsScreen"
    const val HOMESCREEN="HomeScreen"
    const val ONBOARDING="OnBoarding"
    //const val CUSTOMTIMEOUT="TimeOut"


}

@Composable
fun AppNavHost() {
    val navController= rememberNavController()
    NavHost(navController= navController, startDestination = Route.START ){

        composable(route=Route.START){ SplashScreen(navController) }
        composable(route=Route.SIGNUP){ SignUpScreen1(navController) }
        composable(route=Route.SIGNUP2){ SignUpScreen2(navController) }
        composable(route=Route.SIGNIN){ SignInScreen(navController) }
        composable(route=Route.SIGNINADAIN){ SignInAgain(navController) }
        composable(route=Route.PROFILE){ ProfileScreen(navController)}
        composable(route=Route.PROFILEINFO){ ProfileInformationScreen(navController)}
        composable(route=Route.EDITPROFILE){ EditProfile (navController)}
        composable(route=Route.SETTING){ SettingsScreen(navController)}
        composable(route=Route.CHANGPASS){ ChangePassword(navController) }
        composable(route=Route.FAVOURITESCREEN){ FavouriteScreen(navController) }
        composable(route=Route.MORESCREEN){ MoreScreen(navController) }
        composable(route=Route.TRANSACTIONSCREEN){ TransactionScreen(navController) }
        composable(route=Route.CARDSSCREEN){ CardsScreen(navController) }
        composable(route=Route.HOMESCREEN){ HomeScreen(navController) }
        composable(route=Route.BOTTOMNAVSCREEN){ BottomNavScreen(navController) }
        composable(route=Route.ONBOARDING){ OnboardingPager(navController) }
       // composable(route=Route.CUSTOMTIMEOUT){ CustomSnackBar(navController, snackbarData = , modifier = TODO() }


        }
    }
