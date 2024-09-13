package it.dogior.ncc.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.dogior.ncc.R

@Composable
fun ActionCardContentRenderer(actionCardContent: ActionCardContent, modifier: Modifier = Modifier) {
    when(actionCardContent){
        ActionCardContent.PLAY_ICON -> {Icon(
            imageVector = Icons.Rounded.PlayArrow,
            contentDescription = "",
            modifier.padding(8.dp))
        }
        ActionCardContent.SCOREBOARD_POSITION -> {
            Column(
                modifier = modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "7°",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "su 10 ", style = MaterialTheme.typography.bodySmall)
            }
        }
        ActionCardContent.SWORDS_ICON -> {Icon(
            painter = painterResource(id = R.drawable.swords_rounded),
            contentDescription = "",
            modifier = modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun ActionCardContentRendererPreview(){
    ActionCardContentRenderer(ActionCardContent.PLAY_ICON)
}

@Preview
@Composable
fun ActionCardContentRendererPreview2(){
    ActionCardContentRenderer(ActionCardContent.SWORDS_ICON)
}

@Preview
@Composable
fun ActionCardContentRendererPreview3(){
    ActionCardContentRenderer(ActionCardContent.SCOREBOARD_POSITION)
}