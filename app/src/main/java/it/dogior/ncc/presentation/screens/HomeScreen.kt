package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.R
import it.dogior.ncc.presentation.components.MatchCard
import it.dogior.ncc.presentation.components.MatchCardPreview
import it.dogior.ncc.presentation.components.PlayButton

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier
        .fillMaxSize()
        .padding(bottom = 24.dp)) {
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
                .scale(1.2f))

        Row(modifier = Modifier
            .constrainAs(playButtons) {
                top.linkTo(logo.bottom, margin = 48.dp)
                start.linkTo(parent.start, margin = 48.dp)
                end.linkTo(parent.end, margin = 48.dp)
            },
            verticalAlignment = Alignment.CenterVertically) {


            PlayButton(
                "Nuova Partita",
                onClick = { /*TODO*/ },
//                icon = Icons.Rounded.PlayArrow,
                shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
            )
            Spacer(modifier = Modifier.width(1.dp))
            PlayButton(
                "Unisciti a una partita",
                onClick = { /*TODO*/ },
//                icon = Icons.Rounded.PlayArrow,
                shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
            )

        }

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .constrainAs(games) {
                    top.linkTo(playButtons.bottom, margin = 24.dp)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                SectionTitle(text = "In Corso")
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(7) {
                MatchCard("Orlandino16", "La partita finisce in 7 giorni")
                Spacer(modifier = Modifier.height(8.dp))
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                SectionTitle("Cronologia")
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(15) {
                MatchCard("Giacomino01", "Hai vinto 3 - 0")
                Spacer(modifier = Modifier.height(8.dp))
            }
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


@PreviewScreenSizes
@PreviewLightDark
@Preview()
@Composable
fun HomeScreenPreview() {
    NomiCoseCittaTheme {
        HomeScreen()
    }
}