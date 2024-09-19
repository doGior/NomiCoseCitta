package it.dogior.ncc.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme
import it.dogior.ncc.presentation.components.BackIconButton
import it.dogior.ncc.presentation.navigation.LocalTopAppBarData
import it.dogior.ncc.presentation.navigation.TopAppBarData

@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    var effettiSwitch by remember {
        mutableStateOf(true)
    }
    var statusSwitch by remember {
        mutableStateOf(true)
    }
    var lobbySwitch by remember {
        mutableStateOf(true)
    }
    var musicSwitch by remember {
        mutableStateOf(true)
    }

    var accountOptionsVisibility by remember {
        mutableStateOf(false)
    }
    var appOptionsVisibility by remember {
        mutableStateOf(false)
    }
    var creditsVisibility by remember {
        mutableStateOf(false)
    }


    LocalTopAppBarData.current.state = TopAppBarData(title = {
        Text(
            text = "Impostazioni",
            style = MaterialTheme.typography.titleLarge
        )
    }, navigationIcon = {
        BackIconButton(navController = navController)
    })

    val rowHeigth = 48.dp
    val indentedPadding = 24.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(rowHeigth)
                .clickable { /*TODO*/ },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Account",
                style = MaterialTheme.typography.titleSmall,
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = "")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(rowHeigth)
                .clickable { appOptionsVisibility = !appOptionsVisibility },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "App",
                style = MaterialTheme.typography.titleSmall,
            )
            IconButton(onClick = { appOptionsVisibility = !appOptionsVisibility}) {
                Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = "")
            }
        }

        if (appOptionsVisibility){
            Column(modifier = Modifier.fillMaxWidth().padding(start = indentedPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {/* TODO */ }
                        .height(rowHeigth),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Musica", style = MaterialTheme.typography.titleSmall)
                    Switch(checked = musicSwitch, onCheckedChange = { musicSwitch = !musicSwitch })
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {/* TODO */ }
                        .height(rowHeigth),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Effetti audio", style = MaterialTheme.typography.titleSmall)
                    Switch(checked = effettiSwitch, onCheckedChange = { effettiSwitch = !effettiSwitch })
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
                    Switch(checked = lobbySwitch, onCheckedChange = { lobbySwitch = !lobbySwitch })
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(rowHeigth)
                .clickable { /* TODO */ },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Crediti",
                style = MaterialTheme.typography.titleSmall,
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ChevronRight, contentDescription = "")
            }
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