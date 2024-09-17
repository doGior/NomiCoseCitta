package it.dogior.ncc.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import it.dogior.ncc.presentation.viewmodels.LoginState
import it.dogior.ncc.ui.theme.NomiCoseCittaTheme

@Composable
fun ChooseUsernameModal(
    state: LoginState,
    modifier: Modifier = Modifier
) {
    var typedText by remember {
        mutableStateOf("")
    }

    Dialog(onDismissRequest = { /* This Dialog shouldn't be dismissible*/ }) {
        Card(modifier = modifier) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Scegli uno username",
                    style = MaterialTheme.typography.titleSmall.copy(fontSize = 21.sp)
                )
                OutlinedTextField(
                    value = typedText,
                    onValueChange = { typedText = it },
                    label = { Text(text = "Username") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = ""
                        )
                    }
                )
                Button(
                    onClick = {
                        state.username = typedText
                        state.isUsernameChosen = true
                        Log.d("DIALOG", state.toString())
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Text(text = "Conferma")
                }
            }
        }
    }
}

@Preview
@Composable
fun ChooseUsernameModalPreview() {
    NomiCoseCittaTheme {
        ChooseUsernameModal(LoginState())
    }
}