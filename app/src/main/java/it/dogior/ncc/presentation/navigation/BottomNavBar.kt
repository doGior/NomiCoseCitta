package it.dogior.ncc.presentation.navigation

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme
import it.dogior.ncc.presentation.screens.Screen
import it.dogior.ncc.presentation.screens.SerializableIcon
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@Composable
fun BottomNavBar(navController: NavHostController, items: List<Screen>) {

    NavigationBar(
        contentColor = Color.White
    ) {
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        val scale by remember {
            mutableStateOf(Animatable(1f))
        }

        var animateAgain by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = animateAgain) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        OvershootInterpolator(1.5f).getInterpolation(it)
                    }
                )
            )
        }

        items.forEachIndexed { index, screen ->
            val isScreenSelected = selectedItemIndex == index
            NavigationBarItem(
                icon = {
                if (isScreenSelected) {
                    screen.selectedIcon?.let {
                        Icon(
                            imageVector = getIconFromSerializable(it),
                            contentDescription = screen.title,
                            modifier = Modifier.scale(scale.value)
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
                    //TODO: Levare Mainscope e mettere ViewModelScope
                    MainScope().launch {
                        scale.snapTo(0.3f)
                        animateAgain = !animateAgain
                    }
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

fun getIconFromSerializable(serializableIcon: SerializableIcon): ImageVector {
    return if(serializableIcon.isFilled) {
        when(serializableIcon.iconName){
            "Home" -> Icons.Filled.Home
            "List" -> Icons.AutoMirrored.Filled.List
            "Profile" -> Icons.Filled.AccountCircle
            else -> {
                Icons.Filled.QuestionMark}
        }
    } else {
        when(serializableIcon.iconName){
            "Home" -> Icons.Outlined.Home
            "List" -> Icons.AutoMirrored.Outlined.List
            "Profile" -> Icons.Outlined.AccountCircle
            else -> {
                Icons.Outlined.QuestionMark}
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