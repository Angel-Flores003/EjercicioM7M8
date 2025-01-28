package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldBuffer
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ShoppingList1() {
    val viewModel = viewModel { ShoppingListViewModel() }
    ShoppingList(
        viewModel.name.value,
        viewModel.amount.value,
        viewModel::updateName,
        viewModel::updateAmount
    )
}

@Composable
fun ShoppingList(name: String,
                 amount: String,
                 onNamechange:(String)-> Unit,
                 onAmountchange:(String) -> Unit) {
    var shoppingList by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    Column (modifier = Modifier.fillMaxWidth()){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                label = { Text("Name") },
                onValueChange = onNamechange
            )
            OutlinedTextField(
                value = amount,
                label = { Text("Amount") },
                onValueChange = onAmountchange
            )

            Button(onClick = {
                if (name.isNotEmpty() && amount.isNotEmpty())
                {
                    val newshoppingList = shoppingList + (Pair(name, amount))
                    //name = ""
                    //amount = ""
                    shoppingList = newshoppingList
                }}){
                    Text("Add")
                }
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
class ShoppingListViewModel : ViewModel() {
    val name = mutableStateOf("")
    val amount = mutableStateOf("")
    fun updateName(newname: String){
        name.value = newname
    }
    fun updateAmount(newamount : String){
        amount.value = newamount
    }
}