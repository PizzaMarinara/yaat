package dev.efantini.yaat.ui.shared.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.efantini.yaat.ui.home.HomeViewModel
import dev.efantini.yaat.ui.home.elements.HomeContent

@Composable
fun BaseNavHost(
    startDestination: String = NavigationItem.Home.route
) {
    val navController = rememberNavController()
    val homeViewModel = HomeViewModel()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationItem.Home.route) {
            HomeContent(homeViewModel)
        }
        /*
        composable(
            NavigationItem.Profile.fullRoute,
            arguments = listOf(navArgument("profileId") { type = NavType.LongType })
        ) {

            // We can have a reload on the eventual viewmodel before launching

            // LaunchedEffect("navigation") {
            //     profileViewModel.reload(it.arguments?.getLong("profileId"))
            // }

            // ProfileContent(detailViewModel)
            Text("Under Construction")
        }
        */
    }
}
