package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.R

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize().padding(start = 8.dp)) {
        val (title, text) = createRefs()


        Text("Liste",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 16.dp)
            })
        Text(text = "List",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(title.bottom, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 16.dp)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    NomiCoseCittaTheme {
        ListScreen()
    }
}