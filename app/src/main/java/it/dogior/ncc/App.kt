package it.dogior.ncc

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.presentation.navigation.BottomNavBar
import it.dogior.ncc.presentation.navigation.NccNavHost
import it.dogior.ncc.presentation.screens.Screen

val bottomNavBarItems = listOf(
    Screen.HomeScreen,
    Screen.ListsScreen,
    Screen.ProfileScreen,
)

@Composable
fun App() {
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

fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }