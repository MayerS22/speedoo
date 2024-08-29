package com.example.combanquemisrspeedo.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.Authentication.SplashScreen
import com.example.combanquemisrspeedo.authentication.SignInScreen
import com.example.combanquemisrspeedo.authentication.SignUpScreen1

object Route {
    const val START= "splash"
    const val SIGNUP="signUp"
    const val SIGNIN="signIn"

}

@Composable
fun AppNavHost() {
    val navController= rememberNavController()
    NavHost(navController= navController, startDestination = Route.START ){

        composable(route=Route.START){ SplashScreen(navController) }
        composable(route=Route.SIGNUP){ SignUpScreen1(navController) }
        composable(route=Route.SIGNIN){ SignInScreen(navController) }


        }
    }
