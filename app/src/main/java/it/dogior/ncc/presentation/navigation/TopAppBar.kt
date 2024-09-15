package it.dogior.ncc.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


class TopAppBarData(
    navigationIcon:@Composable () -> Unit = {},
    title: @Composable () -> Unit = {},
    actions:@Composable RowScope.() -> Unit = {},
    visibility: Boolean = true
){
    var navigationIcon:@Composable () -> Unit by mutableStateOf(navigationIcon)
    var title: @Composable () -> Unit by mutableStateOf(title)
    var actions:@Composable RowScope.() -> Unit by mutableStateOf(actions)
    var visibility: Boolean by mutableStateOf(visibility)
}

class TopAppBarState{var state: TopAppBarData by mutableStateOf(TopAppBarData())}
var LocalTopAppBarData = compositionLocalOf { TopAppBarState() }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    if (LocalTopAppBarData.current.state.visibility) {
        CenterAlignedTopAppBar(
            modifier = modifier,
            title = LocalTopAppBarData.current.state.title,
            scrollBehavior = scrollBehavior,
            actions = LocalTopAppBarData.current.state.actions,
            navigationIcon = LocalTopAppBarData.current.state.navigationIcon,
        )
    }
}
