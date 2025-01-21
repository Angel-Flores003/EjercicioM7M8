package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

//@Composable
//fun ShoppingList() {
//    val viewModel = viewModel { ShoppingListVewModel() }
//}

@Composable
fun ShoppingList(/*value: String*/) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()){
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
        var list by remember { mutableStateOf("") }
    }
}

//class ShoppingListVewModel : ViewModel() {
//    val name =  mutableStateOf("")
//
//    fun LabelName() {
//
//    }
//}