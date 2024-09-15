package it.dogior.ncc.presentation.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme

@Stable
@Composable
fun UserCard(
    opponent: String,
    matchActivity: String,
    actionCardContent: ActionCardContent,
    modifier: Modifier = Modifier,
    propic: ImageVector = Icons.Rounded.AccountCircle,
) {
    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = modifier,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
            Row {
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (proPic, text, endSurface) = createRefs()
                    Icon(propic, "",
                        Modifier
                            .scale(1.7f)
                            .constrainAs(proPic) {
                                start.linkTo(parent.start, margin = 16.dp)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)

                            }
                    )
                    Column(Modifier.constrainAs(text) {
                        start.linkTo(proPic.end, margin = 20.dp)
                        top.linkTo(parent.top, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                    }) {
                        Text(text = opponent, style = MaterialTheme.typography.titleMedium)
                        Text(text = matchActivity)
                    }


                    ActionCardContentRenderer(actionCardContent,
                        modifier = Modifier.constrainAs(endSurface){
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                            height = Dimension.fillToConstraints
                            width = Dimension.ratio("4:5")
                        })

                }
            }
    }
}

enum class ActionCardContent{
    PLAY_ICON, SWORDS_ICON, SCOREBOARD_POSITION
}


@PreviewLightDark
@Composable
fun MatchCardPreview() {
    NomiCoseCittaTheme {
        UserCard("Orlandino16",
            "La partita finisce in 7 giorni",
            ActionCardContent.SWORDS_ICON)
    }
}

@PreviewLightDark
@Composable
fun MatchCardPreview1() {
    NomiCoseCittaTheme {
        UserCard("Orlandino16",
            "La partita finisce in 7 giorni",
            ActionCardContent.PLAY_ICON)
    }
}

@PreviewLightDark
@Composable
fun MatchCardPreview2() {
    NomiCoseCittaTheme {
        UserCard("Orlandino16",
            "La partita finisce in 7 giorni",
            ActionCardContent.SCOREBOARD_POSITION)
    }
}