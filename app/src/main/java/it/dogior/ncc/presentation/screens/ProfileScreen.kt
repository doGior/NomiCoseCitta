package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import it.dogior.ncc.NomiCoseCittaTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize().padding(start = 8.dp)) {
        val (title, text) = createRefs()


        Text("Profilo",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 16.dp)
            })
        Text(text = "Profile",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(title.bottom, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 16.dp)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    NomiCoseCittaTheme {
        ProfileScreen()
    }
}