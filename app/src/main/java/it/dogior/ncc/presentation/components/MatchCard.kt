package it.dogior.ncc.presentation.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import it.dogior.ncc.NomiCoseCittaTheme

@Composable
fun MatchCard(
    opponent: String,
    matchActivity: String,
    modifier: Modifier = Modifier.width(400.dp),
    propic: ImageVector = Icons.Rounded.AccountCircle
) {
    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = modifier,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (proPic, text, playIcon) = createRefs()
                    Icon(propic, "",
                        Modifier.constrainAs(proPic) {
                            start.linkTo(parent.start, margin = 16.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)

                        }
                    )
                    Column(Modifier.constrainAs(text) {
                        start.linkTo(proPic.end, margin = 16.dp)
                        top.linkTo(parent.top, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                    }) {
                        Text(text = opponent, style = MaterialTheme.typography.titleMedium)
                        Text(text = matchActivity)
                    }

                    Icon(Icons.Rounded.PlayArrow, "",
                        Modifier.constrainAs(playIcon) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end, margin = 24.dp)
                        }
                    )

                }


            }
        }
    }
}

@Preview
@Composable
fun MatchCardPreview() {
    NomiCoseCittaTheme {
        MatchCard("Orlandino16", "La partita finisce in 7 giorni")
    }
}