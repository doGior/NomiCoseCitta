package it.dogior.ncc.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.presentation.getIconFromSerializable
import it.dogior.ncc.presentation.screens.Screen

@Composable
fun BottomNavBar(navController: NavHostController, items: List<Screen>) {

    NavigationBar(
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        items.forEachIndexed { index, screen ->
            val isScreenSelected = selectedItemIndex == index
            NavigationBarItem(icon = {
                if (isScreenSelected) {
                    screen.selectedIcon?.let {
                        Icon(
                            imageVector = getIconFromSerializable(it),
                            contentDescription = screen.title
                        )
                    }
                } else {
                    screen.unselectedIcon?.let {
                        Icon(
                            imageVector = getIconFromSerializable(it),
                            contentDescription = screen.title
                        )
                    }
                }
            },
                label = { Text(text = screen.title) },
                selected = isScreenSelected,
                alwaysShowLabel = false,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(screen) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Preview
@PreviewDynamicColors
@Composable
fun BottomNavBarPreview() {
    val navController = rememberNavController()
    val mainScreenItems = listOf(
        Screen.HomeScreen,
        Screen.ListsScreen,
        Screen.ProfileScreen,
    )
    NomiCoseCittaTheme(darkTheme = true) {
        Surface {
            BottomNavBar(navController, mainScreenItems)
        }
    }
}