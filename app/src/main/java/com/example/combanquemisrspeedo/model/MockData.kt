package com.example.combanquemisrspeedo.model

import androidx.compose.runtime.mutableStateListOf


object MockData {
    var user =
        User(
            fullName = "Mohab Yasser",
            balance = "$10.3",
            email = "mohab@gmail.com",
            dateOfBirth = "1/07/2002",
            country = "Egypt",
            defaultAccountNumber = "Account xxxx6969",
            accounts = mutableStateListOf(
                Account("Long Saving Account", "Account xxxx6969"),
                Account("Current Account", "Account xxxx1111"),
                Account("Credit Account", "Account xxxx2222"),

                ),
            favourites = mutableStateListOf(
                Favourite("Favourite 1", "1234567890"),
                Favourite("Favourite 2", "9876543210")
            ),
            transactions = mutableStateListOf(
                Transaction(
                    1,
                    true,
                    "$2.3",
                    "Mohanad Yasser",
                    "1223xxxxxx",
                    "Visa  - 1234\nToday 11:00 - Received"
                ),
                Transaction(
                    2,
                    false,
                    "$1.1",
                    "Mohamed Magdy",
                    "1223xxxxxx",
                    "Visa  - 1234\nToday 11:00 - Received"
                ),
                Transaction(
                    3,
                    true,
                    "$16.2",
                    "Asmaa Desouky",
                    "1223xxxxxx",
                    "Visa  - 1234\nToday 11:00 - Received"
                ),
                Transaction(
                    4,
                    true,
                    "$16.2",
                    "Asmaa Desouky",
                    "1223xxxxxx",
                    "Visa  - 1234\nToday 11:00 - Received"
                ),
                Transaction(
                    5,
                    true,
                    "$16.2",
                    "Asmaa Desouky",
                    "1223xxxxxx",
                    "Visa  - 1234\nToday 11:00 - Received"
                ),
                Transaction(
                    6,
                    true,
                    "$16.2",
                    "Asmaa Desouky",
                    "1223xxxxxx",
                    "Visa  - 1234\nToday 11:00 - Received"
                ),
            )
        )

}