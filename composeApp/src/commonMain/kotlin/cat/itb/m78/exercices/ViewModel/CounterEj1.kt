package cat.itb.m78.exercices.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Counter()
{
    Row {
        Column {
            var num by remember { mutableStateOf(0) };
            Text ("$num")
            Button(onClick = {num++}) {
                Text ("Score")
            }
        }
        Column {
            var num by remember { mutableStateOf(0) };
            Text ("$num")
            Button(onClick = {num++}) {
                Text ("Score")
            }
        }
    }
}
class CounterEj1 : ViewModel() {
    var num by remember { mutableStateOf(0) };
    Text ("$num")
    fun Try () {
        Button(onClick =
        { num++ })
        {
            Text("Score")
        }
    }
}

class HelloByeViewModel : ViewModel() {
    val text = mutableStateOf("Hello World")
    fun sayBye(){
        text.value = "Bye"
    }
}
@Composable
fun HelloByeVmApp() {
    val viewModel = viewModel { HelloByeViewModel() }
    Button(
        onClick = viewModel::sayBye // or { viewModel.sayBye() }
    ) {
        Text(viewModel.text.value)
    }
}
@Composable
fun HelloByeVmAppv2() {
    val viewModel = viewModel { HelloByeViewModel() }
    HelloByeVmAppv2View(viewModel.text.value, viewModel::sayBye)
}
@Composable
fun HelloByeVmAppv2View(text: String, onSayBye: ()-> Unit) {
    Button(
        onClick = onSayBye // or { viewModel.sayBye() }
    ) {
        Text(text)
    }
}