package it.dogior.ncc.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.dogior.ncc.ui.theme.NomiCoseCittàTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Text(text = "Ciao", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NomiCoseCittàTheme {
        HomeScreen()
    }
}