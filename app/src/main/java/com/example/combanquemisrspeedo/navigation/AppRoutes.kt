package com.example.combanquemisrspeedo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.ui.screens.authentication.SignInAgain
import com.example.combanquemisrspeedo.ui.screens.authentication.SignInScreen
import com.example.combanquemisrspeedo.ui.screens.authentication.SignUpScreen1
import com.example.combanquemisrspeedo.ui.screens.authentication.SignUpScreen2
import com.example.combanquemisrspeedo.ui.screens.authentication.SplashScreen
import com.example.combanquemisrspeedo.ui.screens.main.card.CardsScreen
import com.example.combanquemisrspeedo.model.CustomSnackBar
import com.example.combanquemisrspeedo.ui.screens.error.InternetError
import com.example.combanquemisrspeedo.ui.screens.error.ServerError
import com.example.combanquemisrspeedo.ui.screens.more.FavouriteScreen
import com.example.combanquemisrspeedo.ui.screens.more.MoreScreen
import com.example.combanquemisrspeedo.ui.screens.onBoarding.OnboardingPager
import com.example.combanquemisrspeedo.ui.screens.profile.ChangePassword
import com.example.combanquemisrspeedo.ui.screens.profile.EditProfile
import com.example.combanquemisrspeedo.ui.screens.profile.ProfileInformationScreen
import com.example.combanquemisrspeedo.ui.screens.profile.ProfileScreen
import com.example.combanquemisrspeedo.ui.screens.profile.SettingsScreen
import com.example.combanquemisrspeedo.ui.screens.main.transactions.TransactionScreen
import com.example.combanquemisrspeedo.ui.screens.main.transfer.AmountScreen
import com.example.combanquemisrspeedo.ui.screens.main.transfer.ConfirmationScreen
import com.example.combanquemisrspeedo.ui.screens.main.transfer.HomeScreen
import com.example.combanquemisrspeedo.ui.screens.main.transfer.PaymentScreen

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
    const val AMOUNTSCREEN="AmountScreen"
    const val CONFIRMATIONSCREEN="ConfirmationScreen"
    const val PAYMENTSCREEN="PaymentScreen"
    const val INTERNETERROR="InternetError"
    const val SERVERERROR="ServerError"


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
        composable(route=Route.PROFILE){ ProfileScreen(navController) }
        composable(route=Route.PROFILEINFO){ ProfileInformationScreen(navController) }
        composable(route=Route.EDITPROFILE){ EditProfile (navController) }
        composable(route=Route.SETTING){ SettingsScreen(navController) }
        composable(route=Route.CHANGPASS){ ChangePassword(navController) }
        composable(route=Route.FAVOURITESCREEN){ FavouriteScreen(navController) }
//        composable(route=Route.MORESCREEN){ MoreScreen(navController) }
        composable(route=Route.TRANSACTIONSCREEN){ TransactionScreen(navController) }
//        composable(route=Route.CARDSSCREEN){ CardsScreen(navController) }
//        composable(route=Route.HOMESCREEN){ HomeScreen(navController) }
        composable(route=Route.BOTTOMNAVSCREEN){ BottomNavScreen(navController) }
        composable(route=Route.ONBOARDING){ OnboardingPager(navController) }
        composable(route=Route.AMOUNTSCREEN){ AmountScreen(navController) }
        composable(route=Route.CONFIRMATIONSCREEN){ ConfirmationScreen(navController) }
        composable(route=Route.PAYMENTSCREEN){ PaymentScreen(navController) }
        composable(route=Route.INTERNETERROR){ InternetError(navController) }
        composable(route=Route.SERVERERROR){ ServerError(navController) }



        }
    }
