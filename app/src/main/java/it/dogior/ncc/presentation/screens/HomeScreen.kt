package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.LocalSnackbarHostState
import it.dogior.ncc.R
import it.dogior.ncc.presentation.components.ActionCardContent
import it.dogior.ncc.presentation.components.PlayButton
import it.dogior.ncc.presentation.components.UserCard
import it.dogior.ncc.presentation.navigation.BottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalBottomAppBarData
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.TopAppBarData
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    val logoId = if (isSystemInDarkTheme()) {
        R.drawable.ncc_logo_bianco
    } else {
        R.drawable.ncc_logo_nero
    }

    val scope = rememberCoroutineScope()
    //TopAppBar
    LocalTopAppBarData.current.state = TopAppBarData(title = {
        Image(
            painter = painterResource(id = logoId),
            "", modifier = Modifier
                .scale(1.5f)
                .padding(bottom = 8.dp)
        )
    })
    LocalBottomAppBarData.current.state = BottomAppBarData(visibility = true)

    val snackbarHostState = LocalSnackbarHostState.current
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                PlayButton(
                    "Nuova Partita",
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                PlayButton(
                    "Unisciti a una partita",
                    onClick = { scope.launch { snackbarHostState.showSnackbar("Unisciti a una partita") } },
                    shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                )

            }
        }
        item {
            SectionTitle(text = "In Corso")
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(3) {
            UserCard(
                "Orlandino16",
                "La partita finisce in 7 giorni",
                ActionCardContent.PLAY_ICON
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            SectionTitle("Cronologia")
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(7) {
            UserCard("Giacomino01", "Hai vinto 3 round", ActionCardContent.SCOREBOARD_POSITION)
            Spacer(modifier = Modifier.height(8.dp))
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }
    }
}

@Composable
fun SectionTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true)
@PreviewScreenSizes
@PreviewLightDark
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    NomiCoseCittaTheme {
        HomeScreen(navController)
    }
}