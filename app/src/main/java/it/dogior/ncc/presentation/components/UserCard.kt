package it.dogior.ncc.presentation.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import it.dogior.ncc.NomiCoseCittaTheme

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
        Surface {
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

                    Card(shape = RoundedCornerShape(20),
                        modifier = Modifier.constrainAs(endSurface) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end, margin = 8.dp)
                        }) {
                        ActionCardContentRenderer(actionCardContent)
                    }
                }
            }
        }
    }
}

enum class ActionCardContent{
    PLAY_ICON, SWORDS_ICON, SCOREBOARD_POSITION
}

@Preview
@Composable
fun MatchCardPreview() {
    NomiCoseCittaTheme {
        UserCard("Orlandino16",
            "La partita finisce in 7 giorni",
            ActionCardContent.SWORDS_ICON)
    }
}