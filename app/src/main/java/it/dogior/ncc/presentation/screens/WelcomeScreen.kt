package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme
import it.dogior.ncc.R
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.TopAppBarData

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    LocalTopAppBarData.current.state = TopAppBarData(visibility = false)
    ConstraintLayout(modifier.fillMaxSize()) {
        val (title, illustration, buttons) = createRefs()
        Box(modifier = Modifier.constrainAs(title){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            width = Dimension.fillToConstraints
            }, contentAlignment = Alignment.Center){
            Text(text = "Benvenuto",
                style = MaterialTheme.typography.displayLarge)
        }
        Image(painter = painterResource(id = R.drawable.welcome_illustration),
            contentDescription = "Welcome",
            modifier = Modifier.constrainAs(illustration){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(title.bottom)
                bottom.linkTo(buttons.top)
                width = Dimension.fillToConstraints
            })

        Column(modifier = Modifier.constrainAs(buttons){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 16.dp)
            width = Dimension.fillToConstraints
        }, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Entra con Google")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Entra con email e password")
            }
//            TextButton(onClick = { /*TODO*/ }) {
//                Text(text = "Accesso anonimo")
//            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    NomiCoseCittaTheme {
        WelcomeScreen(Modifier.fillMaxSize())
    }
}