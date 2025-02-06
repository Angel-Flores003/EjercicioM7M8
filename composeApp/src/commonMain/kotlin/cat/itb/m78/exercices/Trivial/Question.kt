package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

@Composable
fun Preguntas() {
    val preguntas = listOf(
        "Cuantos dias tiene un año natural?",
        "Ques és els club del super3?",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "asdadw",
        "",
        "",
        "",
        "",
        ""
    )
}

@Composable
fun Question(
    message: String,
    onSettingsClick: () -> Unit,
//    counterround: Int,
//    onIncreaserCounterRound: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(10.dp))
        Text("Round 1/10", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(100.dp))
        Text("Cuantos dias tiene un año natural?", fontWeight = FontWeight.Black)//Cambiar
        Spacer(Modifier.height(20.dp))
        RowButton1()
        Spacer(Modifier.height(10.dp))
        RowButton2()
    }
}

class CounterRoundViewModel : ViewModel(){
    val counter = mutableStateOf(1)

    fun increaseCounter(){
        counter.value++
    }
}

@Composable
fun RowButton1() {
    Row {
        Button1()
        Spacer(Modifier.width(50.dp))
        Button2()
    }
}

@Composable
fun RowButton2() {
    Row {
        Button3()
        Spacer(Modifier.width(50.dp))
        Button4()
    }
}

@Composable
fun Button1() {
    var error by remember { mutableStateOf(Color.Unspecified) }
    Button(onClick = { error = Color.Red},
        colors = ButtonDefaults.buttonColors(containerColor = error),
        shape = CutCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    Color.Transparent,
                    Color.Red
                )
            )
        )
    ) {
        Text("366")
    }
}

@Composable
fun Button2() {
    var error by remember { mutableStateOf(Color.Unspecified) }
    Button(onClick = {error = Color.Green},
        colors = ButtonDefaults.buttonColors(containerColor = error),
        shape = CutCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    Color.Green,
                    Color.Transparent
                )
            )
        )
    ) {
        Text("365")
    }
}

@Composable
fun Button3() {
    var error by remember { mutableStateOf(Color.Unspecified) }
    Button(onClick = {error = Color.Red},
        colors = ButtonDefaults.buttonColors(containerColor = error),
        shape = CutCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    Color.Transparent,
                    Color.Cyan
                )
            )
        )
    ) {
        Text("200")
    }
}

@Composable
fun Button4() {
    var error by remember { mutableStateOf(Color.Unspecified) }
    Button(onClick = {error = Color.Red},
        colors = ButtonDefaults.buttonColors(containerColor = error),
        shape = CutCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            brush = Brush.horizontalGradient(
                listOf(
                    Color.Yellow,
                    Color.Transparent
                )
            )
        )
    ) {
        Text("350")
    }
}