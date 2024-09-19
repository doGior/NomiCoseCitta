package it.dogior.ncc.presentation.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.CurrentTheme
import it.dogior.ncc.LocalSnackbarHostState
import it.dogior.ncc.LocalTheme
import it.dogior.ncc.R
import it.dogior.ncc.presentation.components.GoogleButtonAppearance
import it.dogior.ncc.presentation.navigation.BottomAppBarContentState
import it.dogior.ncc.presentation.navigation.BottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalBottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.Screen
import it.dogior.ncc.presentation.navigation.TopAppBarContentState
import it.dogior.ncc.presentation.navigation.TopAppBarData
import it.dogior.ncc.presentation.viewmodels.LoginState
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme

@Composable
fun WelcomeScreen(
    navController: NavController,
    state: LoginState,
    onSignIn: (Boolean, Context) -> Unit,
    modifier: Modifier = Modifier
) {
    LocalTopAppBarData.current.state = TopAppBarData(visibility = false)
    LocalBottomAppBarData.current.state = BottomAppBarData(visibility = false)

    val snackbarHost = LocalSnackbarHostState.current
    val context = LocalContext.current
    var isLoggingIn by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = state.uid) {
        if (state.errorMessage == null) {
            if (state.uid != null) {
                snackbarHost.showSnackbar(message = "Benvenuto!")
                navController.navigate(Screen.HomeScreen)
            } else {
                snackbarHost.showSnackbar(message = "???")
            }
        } else {
            snackbarHost.showSnackbar(state.errorMessage)
        }

        Log.d("LOGIN STATE", "In LaunchedEffetct $state")
    }

    ConstraintLayout(modifier.fillMaxSize()) {
        val (title, illustration, buttons) = createRefs()
        Box(modifier = Modifier.constrainAs(title) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            width = Dimension.fillToConstraints
        }, contentAlignment = Alignment.Center) {
            Text(
                text = "Benvenuto",
                style = MaterialTheme.typography.displayLarge
            )
        }
        Image(painter = painterResource(id = R.drawable.welcome_illustration),
            contentDescription = "Welcome",
            modifier = Modifier.constrainAs(illustration) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(title.bottom)
                bottom.linkTo(buttons.top)
                width = Dimension.fillToConstraints
            })

        Column(modifier = Modifier.constrainAs(buttons) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 16.dp)
            width = Dimension.fillToConstraints
        }, horizontalAlignment = Alignment.CenterHorizontally) {

            TextButton(
                onClick = {
                    onSignIn(false, context)
                    isLoggingIn = true
                },
                enabled = !isLoggingIn
            ) {
                GoogleButtonAppearance(!isLoggingIn)
            }

            TextButton(
                onClick = {
                    onSignIn(true, context)
                    isLoggingIn = true
                },
                enabled = !isLoggingIn
            ) {
                Text(text = "Salta")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    CompositionLocalProvider(
        LocalTopAppBarData provides TopAppBarContentState(),
        LocalSnackbarHostState provides SnackbarHostState(),
        LocalBottomAppBarData provides BottomAppBarContentState(),
        LocalTheme provides CurrentTheme()
    ) {
        NomiCoseCittaTheme {
            WelcomeScreen(navController, LoginState(), { _, _ -> }, Modifier.fillMaxSize())
        }
    }
}