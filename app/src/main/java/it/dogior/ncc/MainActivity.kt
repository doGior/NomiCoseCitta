package it.dogior.ncc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.presentation.navigation.BottomNavBar
import it.dogior.ncc.presentation.navigation.NccNavHost
import it.dogior.ncc.presentation.screens.HomeScreen
import it.dogior.ncc.presentation.screens.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val bottomNavBarItems = listOf(
            Screen.HomeScreen,
            Screen.ListsScreen,
            Screen.ProfileScreen,
        )

        setContent {
            NomiCoseCittaTheme {
                var navcontroller = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    BottomNavBar(
                        navController = navcontroller,
                        items = bottomNavBarItems
                    )
                }) { innerPadding ->
                    NomiCoseCittaTheme{
                        NccNavHost(navController = navcontroller, innerPadding = innerPadding)
                    }
                }
            }
        }
    }
}
