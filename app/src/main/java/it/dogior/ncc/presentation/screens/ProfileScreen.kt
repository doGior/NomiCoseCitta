package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.R
import it.dogior.ncc.fadingEdge
import it.dogior.ncc.presentation.components.ActionCardContent
import it.dogior.ncc.presentation.components.UserCard

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fadingEdge(Brush.verticalGradient(0f to Color.Transparent, 0.03f to Color.Red))
    )
    {
        item {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                ConstraintLayout(modifier = Modifier.fillMaxWidth())
                {
                    val (title, settingsIcon) = createRefs()
                    Text("Profilo",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.constrainAs(title) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        })
                    Icon(imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                        modifier = Modifier
                            .constrainAs(settingsIcon) {
                                top.linkTo(parent.top, margin = 16.dp)
                                bottom.linkTo(parent.bottom, margin = 16.dp)
                                end.linkTo(parent.end, margin = 16.dp)
                            }
                            .clickable { /* TODO */ })
                }

                Image(
                    painter = painterResource(
                        id = R.drawable.propic_octopus
                    ),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .border(
                            4.dp,
                            MaterialTheme.colorScheme.secondaryContainer,
                            RoundedCornerShape(100.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Richie_rich",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )
                ElevatedCard {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "50", style = MaterialTheme.typography.displaySmall)
                            Text(
                                text = "Partite Giocate",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.width(80.dp),
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Black)
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "27", style = MaterialTheme.typography.displaySmall)
                            Text(
                                text = "Partite Vinte",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.width(80.dp),
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Black)
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "150", style = MaterialTheme.typography.displaySmall)
                            Text(
                                text = "Punti Totali",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Black),
                                modifier = Modifier.width(80.dp)
                            )

                        }
                    }
                }


            }
        }

        item {
            Text(
                text = "Amici",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        items(7) {
            UserCard(
                opponent = "Orlandino16",
                matchActivity = "Ultimo scontro: ieri",
                actionCardContent = ActionCardContent.SWORDS_ICON,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@PreviewScreenSizes
@Composable
fun ProfileScreenPreview() {
    NomiCoseCittaTheme {
        ProfileScreen()
    }
}