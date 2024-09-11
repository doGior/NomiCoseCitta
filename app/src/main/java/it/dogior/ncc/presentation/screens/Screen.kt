package it.dogior.ncc.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(
    val route: String,
    var selected_icon: ImageVector?,
    var unselected_icon: ImageVector?,
    var title: String
) {
    object HomeScreen :
        Screen(
            "homeScreen",
            Icons.Filled.Home,
            Icons.Outlined.Home,
            "Home"
        )

    object ListsScreen :
        Screen(
            "listScreen",
            Icons.AutoMirrored.Filled.List,
            Icons.AutoMirrored.Outlined.List,
            "Liste"
        )

    object ProfileScreen :
        Screen(
            "profileScreen",
            Icons.Filled.AccountCircle,
            Icons.Outlined.AccountCircle,
            "Profilo"
        )

    object SettingsScreen :
        Screen(
            "settingsScreen",
            null,
            null,
            "Impostazioni"
        )

    object NewGameScreen :
        Screen(
            "newGameScreen",
            null,
            null,
            "Crea Partita"
        )

    object JoinGameScreen :
        Screen(
            "joinGameScreen",
            null,
            null,
            "Unisciti a una partita"
        )

    object WelcomeScreen :
        Screen(
            "welcomeScreen",
            null,
            null,
            "Benvenuto"
        )
}
