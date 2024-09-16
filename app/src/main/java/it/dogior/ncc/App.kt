package it.dogior.ncc

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.presentation.navigation.BottomAppBarContentState
import it.dogior.ncc.presentation.navigation.BottomNavBar
import it.dogior.ncc.presentation.navigation.LocalBottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.NccNavHost
import it.dogior.ncc.presentation.navigation.TopAppBar
import it.dogior.ncc.presentation.navigation.TopAppBarContentState
import it.dogior.ncc.presentation.screens.Screen
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme

val bottomNavBarItems = listOf(
    Screen.HomeScreen,
    Screen.ListsScreen,
    Screen.ProfileScreen,
)

var LocalSnackbarHostState =
    compositionLocalOf<SnackbarHostState> { error("No SnackbarHostState provided") }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    NomiCoseCittaTheme {
        val navController = rememberNavController()
        val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

        CompositionLocalProvider(
            LocalTopAppBarData provides TopAppBarContentState(),
            LocalSnackbarHostState provides SnackbarHostState(),
            LocalBottomAppBarData provides BottomAppBarContentState()
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                snackbarHost = {
                    SnackbarHost(hostState = LocalSnackbarHostState.current)
                },
                bottomBar = {
                    if (LocalBottomAppBarData.current.state.visibility) {
                        BottomNavBar(
                            navController = navController,
                            items = bottomNavBarItems,
                        )
                    }
                },
                topBar = { TopAppBar(scrollBehavior) }) { innerPadding ->
                NccNavHost(navController = navController, innerPadding = innerPadding)
            }
        }
    }
}