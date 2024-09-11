package it.dogior.ncc.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.dogior.ncc.presentation.screens.HomeScreen
import it.dogior.ncc.presentation.screens.ListScreen
import it.dogior.ncc.presentation.screens.ProfileScreen
import it.dogior.ncc.presentation.screens.Screen


@Composable
fun NccNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    //val context = LocalContext.current
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(modifier = Modifier.padding(innerPadding) ) }

        composable(Screen.ListsScreen.route) {
            ListScreen(modifier = Modifier.padding(innerPadding) ) }

        composable(Screen.ProfileScreen.route) {
            ProfileScreen(modifier = Modifier.padding(innerPadding) ) }

//        composable(MainScreen.SearchScreen.route) { SearchScreen(navController = navController,
//            modifier = Modifier.padding(innerPadding)) }
//
//        composable(MainScreen.LibraryScreen.route) { LibraryScreen(navController = navController,
//            modifier = Modifier.padding(innerPadding)) }
//
//        composable(MainScreen.SettingsScreen.route) { SettingsScreen(navController = navController,
//            modifier = Modifier.padding(innerPadding)) }
    }
    //BottomNavigationBar(navController = navController)
}
