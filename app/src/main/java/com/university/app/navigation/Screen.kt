package com.university.app.navigation

sealed class Screen(val route: String) {
    object Listing : Screen("listing")
}
