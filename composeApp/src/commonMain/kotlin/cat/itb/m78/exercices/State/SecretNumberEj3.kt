package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em

@Composable
fun SecretNumber()
{
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()){
        Text("Endevina el número secret", fontWeight = FontWeight.Bold)
        var text by remember { mutableStateOf("") }
        OutlinedTextField(text,
            label = { Text("") },
            onValueChange = {
                text = it
            })
        var showDialog by remember { mutableStateOf(false) }
        if (showDialog)
            AlertDialog(
                onDismissRequest={showDialog = false},
                confirmButton={},
                text = {Text("HELLO " + text)}
            )
        Button(onClick = { showDialog = true }) {
            Text("Validar")
        }
        var textI by remember{ mutableStateOf("Intents: 0" ) }
        Text(text = textI)
    }
}