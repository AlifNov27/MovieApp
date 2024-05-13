package com.infinitelearning.movieapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.infinitelearning.movieapp.R
import com.infinitelearning.movieapp.navigation.NavigationItem
import com.infinitelearning.movieapp.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfiniteApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val title = when(currentRoute) {
        "home" -> "Home"
        "search" -> "Search"
        "profile" -> "Profile"
        else -> "Detail Movie"
    }

    Scaffold(
        topBar = {
            if (title == "Detail Movie") {
                TopAppBar(
                    title = { Text(text = title) },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                            )
                        }
                    }
                )
            } else {
                TopAppBar(title = { Text(title) }
                )
            }
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Search.route) {
                SearchScreen(navController)
            }

            composable(Screen.Profile.route) {
                ProfileScreen()
            }

            composable(
                Screen.Detail.route + "u/{upcomingId}",
                arguments = listOf(navArgument("upcomingId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailUpcomingScreen(
                    navController = navController,
                    upcomingId = navBackStackEntry.arguments?.getInt("upcomingId")
                )
            }
            composable(
                Screen.Detail.route + "n/{nowPlayingId}",
                arguments = listOf(navArgument("nowPlayingId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailNowPlayingScreen(
                    navController = navController,
                    nowPlayingId = navBackStackEntry.arguments?.getInt("nowPlayingId")
                )
            }
            composable(
                Screen.Detail.route + "/{nowPlayingId}",
                arguments = listOf(navArgument("nowPlayingId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailSearchScreen(
                    navController = navController,
                    SearchId  = navBackStackEntry.arguments?.getInt("nowPlayingId")
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_search),
                icon = Icons.Default.Search,
                screen = Screen.Search
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.Face,
                screen = Screen.Profile
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}
