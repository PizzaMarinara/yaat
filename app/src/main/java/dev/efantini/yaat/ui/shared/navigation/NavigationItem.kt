package dev.efantini.yaat.ui.shared.navigation

sealed class NavigationItem(
    val route: String,
    val fullRoute: String,
    var title: String
) {
    object Home : NavigationItem(
        "home", "home", "home"
    )

    object Profile : NavigationItem(
        "profile", "profile/{profileId}", "profile"
    )
}
