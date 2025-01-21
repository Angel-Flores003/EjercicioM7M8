package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ShoppingList() {
    Column (){
        var name by remember { mutableStateOf("") }
        OutlinedTextField(name,
            label = { Text("Name") },
            onValueChange = {
                name = it
            })
        var amount by remember { mutableStateOf("") }
        OutlinedTextField(amount,
            label = { Text("Amount") },
            onValueChange = {
                amount = it
            })
        Button(onClick = {}) {
            Text ("Add")
        }
    }
}