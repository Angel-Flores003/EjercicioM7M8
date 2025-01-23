package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingList() {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var shoppingList by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                label = { Text("Name") },
                onValueChange = { name = it }
            )

            OutlinedTextField(
                value = amount,
                label = { Text("Amount") },
                onValueChange = { amount = it }
            )

            Button(onClick = {
                if (name.isNotEmpty() && amount.isNotEmpty()) {
                    val newshoppingList = shoppingList + (Pair(name, amount))
                    name = ""
                    amount = ""
                    shoppingList = newshoppingList
                }
            }) {
                Text("Add")
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        LazyColumn {
            items(shoppingList) { item ->
                Row {
                    Text("${item.first}", textAlign = TextAlign.Left, modifier = Modifier.width(150.dp))
                    Text("${item.second}", textAlign = TextAlign.End)
                }
            }
        }
    }
}