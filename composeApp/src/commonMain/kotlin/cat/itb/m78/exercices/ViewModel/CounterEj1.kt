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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Counter() {
    val viewModel = viewModel { CounterViewModel() }
    val value = viewModel.counter.value
    Counter(value, viewModel::increaseCounter)

}

@Composable
fun Counter(value: Int, onIncreaserCounter: ()->Unit) {
    Row {
        Column {
            Text ("$value")
            Button(onClick = onIncreaserCounter) {
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

class CounterViewModel : ViewModel(){
    val counter = mutableStateOf(0)

    fun increaseCounter(){
        counter.value++
    }
}