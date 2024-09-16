package it.dogior.ncc.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.dogior.ncc.presentation.screens.HomeScreen
import it.dogior.ncc.presentation.screens.ListScreen
import it.dogior.ncc.presentation.screens.ProfileScreen
import it.dogior.ncc.presentation.screens.Screen
import it.dogior.ncc.presentation.screens.SettingsScreen
import it.dogior.ncc.presentation.screens.WelcomeScreen
import it.dogior.ncc.presentation.viewmodels.LoginViewModel


@Composable
fun NccNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    //val context = LocalContext.current
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen) {

        composable<Screen.HomeScreen> {
            HomeScreen(navController, modifier = Modifier.padding(innerPadding))
        }

        composable<Screen.ListsScreen> {
            ListScreen(navController, modifier = Modifier.padding(innerPadding))
        }

        composable<Screen.ProfileScreen> {
            ProfileScreen(navController, modifier = Modifier.padding(innerPadding))
        }

        composable<Screen.SettingsScreen> {
            SettingsScreen(navController, modifier = Modifier.padding(innerPadding))
        }

        composable<Screen.WelcomeScreen> {
            val viewModel = viewModel<LoginViewModel>()
            WelcomeScreen(
                navController,
                state = viewModel.state,
                onAction = viewModel::handleGoogleLogIn,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
