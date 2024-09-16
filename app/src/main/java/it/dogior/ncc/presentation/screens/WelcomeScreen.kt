package it.dogior.ncc.presentation.screens

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import it.dogior.ncc.LocalSnackbarHostState
import it.dogior.ncc.R
import it.dogior.ncc.domain.auth.AccountManager
import it.dogior.ncc.presentation.navigation.BottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalBottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.TopAppBarData
import it.dogior.ncc.presentation.viewmodels.LoginState
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(
    navController: NavController,
    state: LoginState,
    onAction: (AccountManager) -> Unit,
    modifier: Modifier = Modifier
) {
    LocalTopAppBarData.current.state = TopAppBarData(visibility = false)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val accountManager = remember {
        AccountManager(context as ComponentActivity)
    }
    val snackbarHost = LocalSnackbarHostState.current
    LocalBottomAppBarData.current.state = BottomAppBarData(visibility = false)

    LaunchedEffect(key1 = state.isLoggedIn) {
        if (state.username != null) {
            snackbarHost.showSnackbar(message = "Ciao ${state.username}!")
            navController.navigate(Screen.HomeScreen)
        }
        Log.d("LOGIN STATE", "In LaunchedEffetc ${state.toString()}")
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
            Button(onClick = {
                onAction(accountManager)
            }) {
                Text(text = "Entra con Google")
            }
            Button(
                onClick = { scope.launch { snackbarHost.showSnackbar("Questo non funziona :(") } },
                enabled = false
            ) {
                Text(text = "Entra con email e password")
            }
//            TextButton(onClick = { /*TODO*/ }) {
//                Text(text = "Accesso anonimo")
//            }

        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun WelcomeScreenPreview() {
//    val navController = rememberNavController()
//    NomiCoseCittaTheme {
//        WelcomeScreen(navController, Modifier.fillMaxSize())
//    }
//}