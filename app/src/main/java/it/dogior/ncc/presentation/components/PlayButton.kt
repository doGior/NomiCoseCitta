package it.dogior.ncc.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import it.dogior.ncc.NomiCoseCittaTheme

@Composable
fun PlayButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    icon: ImageVector? = null,
    shape: Shape = RoundedCornerShape(16.dp)
) {
    Button(
        modifier = Modifier
            .height(70.dp)
            .width(155.dp),
        shape = shape,
        onClick = onClick
    ) {
        ConstraintLayout(modifier.fillMaxSize()) {
            val (iconRef, label) = createRefs()
            if (icon != null) {
                Icon(icon, contentDescription = "",
                    modifier.constrainAs(iconRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(label.start)
                    })
            }
            Text(
                text = text, modifier = modifier.constrainAs(label) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(iconRef.end, margin = 8.dp)
                    end.linkTo(parent.end)
                },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            )
        }

    }
}

@Preview
@Composable
fun PlayButtonPreview() {
    NomiCoseCittaTheme {
        PlayButton(text = "Unisciti a una partita")
    }
}

@Preview
@Composable
fun PlayButtonPreview2() {
    NomiCoseCittaTheme {
        PlayButton(
            text = "Unisciti a una partita",
            icon = Icons.Rounded.PlayArrow
        )
    }
}