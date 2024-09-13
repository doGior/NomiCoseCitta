package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import it.dogior.ncc.NomiCoseCittaTheme

@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    var audioSwitch by remember {
        mutableStateOf(true)
    }
    var statusSwitch by remember {
        mutableStateOf(true)
    }
    var lobbySwitch by remember {
        mutableStateOf(true)
    }

    val rowHeigth = 48.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {/* TODO */ }
                .height(rowHeigth),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Audio", style = MaterialTheme.typography.titleSmall)
            Switch(checked = audioSwitch, onCheckedChange = {audioSwitch = !audioSwitch})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {/* TODO */ }
                .height(rowHeigth),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Online status", style = MaterialTheme.typography.titleSmall)
            Switch(checked = statusSwitch, onCheckedChange = {statusSwitch = !statusSwitch})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {/* TODO */ }
                .height(rowHeigth),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Ricorda impostazioni lobby", style = MaterialTheme.typography.titleSmall)
            Switch(checked = lobbySwitch, onCheckedChange = {lobbySwitch = !lobbySwitch})
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(rowHeigth)
                .clickable { /*TODO*/ },
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Crediti",
                style = MaterialTheme.typography.titleSmall,
            )
        }

        Button(
            onClick = {/* TODO */ },
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Supportami 💶", style = MaterialTheme.typography.titleSmall)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    val navController = rememberNavController()
    NomiCoseCittaTheme {
        SettingsScreen(navController)
    }
}