package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme
import it.dogior.ncc.presentation.components.CategoryNote
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.TopAppBarData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ListScreen(navController: NavController, modifier: Modifier = Modifier) {
    LocalTopAppBarData.current.state = TopAppBarData(title = { Text(text = "Categorie")})
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        val (text, fab) = createRefs()

        LazyColumn(
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 32.dp)
                    width = Dimension.matchParent
                }
        ) {
            item {
                CategoryNote(
                    nomeLista = "🏴‍☠️ Lista 1",
                    text = "Pokemon, Supereroi, Città, Nazioni",
                    modifier = Modifier.padding(8.dp)
                )
            }
            item {
                CategoryNote(
                    nomeLista = "🍕 Lista 3",
                    text = "Pokemon, Supereroi, Città, Nazioni, Divinità greche, Piante, Droghe, Medicine, Nomi per cani, Imperatori romani",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        ExtendedFloatingActionButton(
            onClick = { /* TODO */ },
            icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
            text = { Text(text = "Aggiungi") },
            modifier = Modifier.constrainAs(fab) {
                end.linkTo(parent.end, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 16.dp)
            }
        )
    }
}

@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    val navController = rememberNavController()
    NomiCoseCittaTheme {
        ListScreen(navController)
    }
}