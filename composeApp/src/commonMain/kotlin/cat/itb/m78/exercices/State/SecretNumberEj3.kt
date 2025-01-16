package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun SecretNumber() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        val secretNumber = remember { Random.nextInt(0, 101) }
        var text by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }
        var attempts by remember { mutableStateOf(0) }
        Text("Endevina el número secret", fontWeight = FontWeight.Bold)

        OutlinedTextField(text,
            label = { Text("") },
            onValueChange = {
                text = it
            })
        var TextIntent by remember { mutableStateOf(false) }
        Button(
            onClick = {
                val userInput = text.toIntOrNull()
                if (userInput == null) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Si us plau, introdueix un número vàlid.")
                    }
                } else {
                    attempts++
                    when {
                        userInput < secretNumber -> {
                            message = "El número que busques és més gran"
                        }
                        userInput > secretNumber -> {
                            message = "El número que busques és més petit"
                        }
                        else -> {
                            message = "Has encertat! El número era $secretNumber"
                        }
                    }

                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message)
                    }
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Validar")
        }

        // Mostrar els intents realitzats
        Text("Intents: $attempts", modifier = Modifier.padding(top = 16.dp))
        Text(message)
    }
}