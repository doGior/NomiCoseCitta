package it.dogior.ncc.presentation.screens

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(
    var selectedIcon: SerializableIcon?,
    var unselectedIcon: SerializableIcon?,
    var title: String
) {
    @Serializable
    data object HomeScreen :
        Screen(
            SerializableIcon("Home", isFilled = true),
            SerializableIcon("Home", isFilled = false),
            "Home"
        )

    @Serializable
    data object ListsScreen :
        Screen(
            SerializableIcon("List", isFilled = true),
            SerializableIcon("List", isFilled = false),
            "Liste"
        )

    @Serializable
    data object ProfileScreen :
        Screen(
            SerializableIcon("Profile", isFilled = true),
            SerializableIcon("Profile", isFilled = false),
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
            "Crea Partita"
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

@Serializable
data class SerializableIcon(val iconName: String, val isFilled: Boolean)
