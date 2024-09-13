package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.R
import it.dogior.ncc.fadingEdge
import it.dogior.ncc.presentation.components.ActionCardContent
import it.dogior.ncc.presentation.components.UserCard
import it.dogior.ncc.presentation.components.PlayButton

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        val (logo, playButtons, games) = createRefs()
        val logoId = if (isSystemInDarkTheme()) {
            R.drawable.ncc_logo_bianco
        } else {
            R.drawable.ncc_logo_nero
        }

        Image(painter = painterResource(id = logoId),
            "",
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(parent.top, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .scale(1.5f))

        Row(
            modifier = Modifier
                .constrainAs(playButtons) {
                    top.linkTo(logo.bottom, margin = 38.dp)
                    start.linkTo(parent.start, margin = 48.dp)
                    end.linkTo(parent.end, margin = 48.dp)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {


            PlayButton(
                "Nuova Partita",
                onClick = { /*TODO*/ },
//                icon = Icons.Rounded.PlayArrow,
                shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
            )
            Spacer(modifier = Modifier.width(2.dp))
            PlayButton(
                "Unisciti a una partita",
                onClick = { /*TODO*/ },
//                icon = Icons.Rounded.PlayArrow,
                shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
            )

        }

        LazyColumn(
            Modifier
                .fadingEdge(Brush.verticalGradient(0f to Color.Transparent, 0.03f to Color.Red))
                .constrainAs(games) {
                    top.linkTo(playButtons.bottom, margin = 16.dp)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.preferredWrapContent
                }
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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