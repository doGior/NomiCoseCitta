package it.dogior.ncc.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.R

@Composable
fun ActionCardContentRenderer(actionCardContent: ActionCardContent, modifier: Modifier = Modifier) {
    val contentColor = MaterialTheme.colorScheme.onSurface
    val sidesPadding = 13.dp
    Card(
        shape = RoundedCornerShape(20),
        modifier = modifier
            .padding(top = sidesPadding, bottom = sidesPadding, end = sidesPadding)
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max),
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            when (actionCardContent) {
                ActionCardContent.PLAY_ICON -> {
                    Icon(
                        imageVector = Icons.Rounded.PlayArrow,
                        contentDescription = "",
                        modifier = Modifier.scale(1.5f),
                        tint = contentColor
                    )
                }

                ActionCardContent.SCOREBOARD_POSITION -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    )
                    {
                        Text(
                            text = " 7°",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = contentColor
                        )
                        Text(text = "su 10 ", style = MaterialTheme.typography.bodySmall)
                    }
                }

                ActionCardContent.SWORDS_ICON -> {
                    Icon(
                        painter = painterResource(id = R.drawable.swords_rounded),
                        contentDescription = "",
                        modifier = Modifier.scale(1.2f),
                        tint = contentColor
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun ActionCardContentRendererPreview() {
    NomiCoseCittaTheme {
        ActionCardContentRenderer(ActionCardContent.PLAY_ICON)
    }
}

@Preview
@Composable
fun ActionCardContentRendererPreview2() {
    NomiCoseCittaTheme {
        ActionCardContentRenderer(
            ActionCardContent.SWORDS_ICON,
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
        )
    }
}

@Preview
@Composable
fun ActionCardContentRendererPreview3() {
    NomiCoseCittaTheme {
        ActionCardContentRenderer(ActionCardContent.SCOREBOARD_POSITION)
    }
}