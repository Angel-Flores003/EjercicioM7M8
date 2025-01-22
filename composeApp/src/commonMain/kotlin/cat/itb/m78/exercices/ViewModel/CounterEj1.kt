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
    Counter(viewModel.counter1.value, viewModel.counter2.value, viewModel::increaseCounter1, viewModel::increaseCounter2)

}

@Composable
fun Counter(
    counter1: Int,
    counter2: Int,
    onIncreaserCounter1: ()->Unit,
    onIncreaserCounter2: () -> Unit
) {
    Row {
        SingleCounter(counter1, onIncreaserCounter1)
        SingleCounter(counter2, onIncreaserCounter2)
    }
}

class CounterViewModel : ViewModel(){
    val counter1 = mutableStateOf(0)
    val counter2 = mutableStateOf(0)

    fun increaseCounter1(){
        counter1.value++
    }
    fun increaseCounter2(){
        counter2.value++
    }
}

@Composable
fun SingleCounter(counter: Int, onIncreaserCounter: () -> Unit) {
    Column {
        Text(counter.toString())
        Button(onClick = onIncreaserCounter) {
            Text("Count")
        }
    }
}