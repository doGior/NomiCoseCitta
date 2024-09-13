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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.R

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        val (titleRow, profileSection, friendList) = createRefs()

        ConstraintLayout(modifier = Modifier.constrainAs(titleRow) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            width = Dimension.matchParent
        }) {
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

        ConstraintLayout(modifier = Modifier.constrainAs(profileSection) {
            top.linkTo(titleRow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.matchParent
        }) {
            val (propic, stats) = createRefs()
            Image(painter = painterResource(
                id = R.drawable.propic_octopus
            ),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .constrainAs(propic) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .clip(RoundedCornerShape(100.dp))
                    .border(
                        4.dp,
                        MaterialTheme.colorScheme.secondaryContainer,
                        RoundedCornerShape(100.dp)
                    ),
                contentScale = ContentScale.Crop)

            ElevatedCard(modifier = Modifier.constrainAs(stats) {
                start.linkTo(parent.start)
                top.linkTo(propic.bottom, margin = 16.dp)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }) {
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
                            text = "Partite \nGiocate",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Black)
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "27", style = MaterialTheme.typography.displaySmall)
                        Text(text = "Partite \nVinte",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Black))
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "150", style = MaterialTheme.typography.displaySmall)
                        Text(text = "Punti \nTotali",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Black))
                    }
                }
            }
        }

        LazyColumn(modifier = Modifier.constrainAs(friendList) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(profileSection.bottom, margin = 16.dp)
            width = Dimension.fillToConstraints
        }) {
            item { Text(text = "Amici", style = MaterialTheme.typography.titleMedium) }
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