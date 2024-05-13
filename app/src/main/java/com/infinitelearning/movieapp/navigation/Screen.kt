package com.infinitelearning.movieapp.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Search: Screen("search")
    data object Profile: Screen("profile")
    data object Detail: Screen("detail_movie")
}