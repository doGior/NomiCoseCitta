package it.dogior.ncc.presentation.navigation

import it.dogior.ncc.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(
    var selectedIcon: Int?,
    var unselectedIcon: Int?,
    var title: String
) {
    @Serializable
    data object HomeScreen :
        Screen(
            R.drawable.navigationicon_home,
            R.drawable.navigationicon_home_outline,
            "Home"
        )

    @Serializable
    data object ListsScreen :
        Screen(
            R.drawable.navigationicon_list_circle,
            R.drawable.navigationicon_list_circle_outline,
            "Liste"
        )

    @Serializable
    data object ProfileScreen :
        Screen(
            R.drawable.navigationicon_person_circle,
            R.drawable.navigationicon_person_circle_outline,
            "Profilo"
        )

    @Serializable
    data object SettingsScreen :
        Screen(
            null,
            null,
            "Impostazioni"
        )

    @Serializable
    data object NewGameScreen :
        Screen(
            null,
            null,
            "Crea partita"
        )

    @Serializable
    data object JoinGameScreen :
        Screen(
            null,
            null,
            "Unisciti a una partita"
        )

    @Serializable
    data object WelcomeScreen :
        Screen(
            null,
            null,
            "Benvenuto"
        )
}
