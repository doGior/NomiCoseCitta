package it.dogior.ncc.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.presentation.screens.Screen

@Composable
fun BottomNavBar(navController: NavHostController, items: List<Screen>) {

    NavigationBar(
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            val isScreenSelected = currentRoute == screen.route
            NavigationBarItem(icon = {
                if (isScreenSelected) {
                    screen.selected_icon?.let {
                        Icon(
                            imageVector = it, contentDescription = screen.title
                        )
                    }
                } else {
                    screen.unselected_icon?.let {
                        Icon(
                            imageVector = it, contentDescription = screen.title
                        )
                    }
                }
            },
                label = { Text(text = screen.title) },
                selected = isScreenSelected,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(screen.route) {
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