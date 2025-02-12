package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Preguntas(
    val text: String,
    val respuestas: List<String>,
    val correct: String
)

val questions = listOf(Preguntas("¿Cuál es la capital de Francia?", listOf("París", "Madrid", "Berlín", "Roma"), "París"),
    Preguntas("¿Cuánto es 5 x 6?", listOf("11", "30", "56", "25"), "30"),
    Preguntas("¿Quién escribió 'Don Quijote'?", listOf("Cervantes", "Borges", "García Márquez", "Shakespeare"),"Cervantes"),
    Preguntas( "¿Cuál es la evolución de Dunsparce?", listOf("Dudunsparce", "Serperior", "Flygon", "Vivillon"), "Dudunsparce"),
    Preguntas( "¿Cuántas horas debería dormir un adulto?", listOf("7-9", "8-10", "Domrir es de debiles", "3"), "7-9"),
    Preguntas( "¿Cual es el animal volador más rápido?", listOf("Kuervo", "Halcón peregrino", "Colibrí", "Aguila"), "Halcón peregrino"),
    Preguntas( "¿Cuántos continentes hay?", listOf("5", "7", "10", "3"), "7"),
    Preguntas( "¿Cuantos huesos tiene el cuerpo humano?", listOf("169", "200", "206", "201"), "206"),
    Preguntas( "Stop Gambling", listOf("¿Porque?", "No", "Todas son correctas", "Nunca"), "Todas son correctas"),
    Preguntas( "¿Quien dijo esta frase? 'Soy el unico, que decide'", listOf("Escanor", "Asta", "Hinata", "L"), "Escanor"),
    Preguntas( "¿Cuantos dias tiene un año natural?", listOf("366", "365", "360", "370"), "365"),
    Preguntas( "¿Cuantos meses tienen 30 dias?", listOf("12", "11", "4", "1"), "11"),
    Preguntas( "¿Qué dia se dijo esta frase? 'Si ayer fuese mañana, hoy seria viernes'", listOf("viernes", "Sabado", "Domingo", "Jueves"), "Domingo"),
    Preguntas( "¿Son mejore slos perros o los gatos?", listOf("Los Gatos", "Los perros", "Cada uno tiene sus cosas", "Prefiero los hamsters"), "Cada uno tiene sus cosas"),
    Preguntas( "¿Cuando se creó minecraft?", listOf("2002", "2020", "2011", "2035"), "2011"))

//@Composable
//fun TrivialGame() {
//    val questions = remember {
//        mutableStateListOf(
//
//        )
//    }
//}

class QuestionViewModel : ViewModel(){
    var i = 0
    val question = questions[i]

    fun onAnswerSelected(selected: String){
        i++
    }
}

@Composable
fun Question(){
    val viewModel = viewModel { QuestionViewModel() }
    Question(viewModel.question, {}, viewModel::onAnswerSelected, 0, {})
}

@Composable
fun Question(
    question: Preguntas,
    onResultShow: () -> Unit,
    onAnswerSelected: (String) -> Unit,
    counterround: Int,
    onIncreaserCounterRound: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(10.dp))
        Text("Round ${counterround}/10", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(200.dp))
        Text(text = question.text, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ){
//        repeat(4){
//            Button(onClick = {}){
//                Text(question.respuestas[it])
//            }
//        }

        Row {
            Button(onClick = {},
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
                Text(question.respuestas[0])
            }
            Spacer(Modifier.width(50.dp))
            Button(onClick = {},
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
                Text(question.respuestas[1])
            }
        }
        Spacer(Modifier.height(50.dp))
        Row {
            Button(onClick = {},
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
                Text(question.respuestas[2])
            }
            Spacer(Modifier.width(50.dp))
            Button(onClick = {},
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
                Text(question.respuestas[3])
            }
        }
    }
}

class CounterRoundViewModel : ViewModel(){
    val counter = mutableStateOf(1)

    fun increaseCounter(){
        counter.value++
    }
}

//@Composable
//fun RowButton1() {
//    Row {
//        Button1()
//        Spacer(Modifier.width(50.dp))
//        Button2()
//    }
//}
//
//@Composable
//fun RowButton2() {
//    Row {
//        Button3()
//        Spacer(Modifier.width(50.dp))
//        Button4()
//    }
//}
//
//@Composable
//fun Button1(question: Preguntas) {
//    var error by remember { mutableStateOf(Color.Unspecified) }
//    Button(onClick = { error = Color.Red},
//        colors = ButtonDefaults.buttonColors(containerColor = error),
//        shape = CutCornerShape(4.dp),
//        border = BorderStroke(
//            width = 2.dp,
//            brush = Brush.horizontalGradient(
//                listOf(
//                    Color.Transparent,
//                    Color.Red
//                )
//            )
//        )
//    ) {
//        Text("366")
//    }
//}
//
//@Composable
//fun Button2(question: Preguntas) {
//    var error by remember { mutableStateOf(Color.Unspecified) }
//    Button(onClick = {error = Color.Green},
//        colors = ButtonDefaults.buttonColors(containerColor = error),
//        shape = CutCornerShape(4.dp),
//        border = BorderStroke(
//            width = 2.dp,
//            brush = Brush.horizontalGradient(
//                listOf(
//                    Color.Green,
//                    Color.Transparent
//                )
//            )
//        )
//    ) {
//        Text("365")
//    }
//}
//
//@Composable
//fun Button3(question: Preguntas) {
//    var error by remember { mutableStateOf(Color.Unspecified) }
//    Button(onClick = {error = Color.Red},
//        colors = ButtonDefaults.buttonColors(containerColor = error),
//        shape = CutCornerShape(4.dp),
//        border = BorderStroke(
//            width = 2.dp,
//            brush = Brush.horizontalGradient(
//                listOf(
//                    Color.Transparent,
//                    Color.Cyan
//                )
//            )
//        )
//    ) {
//        Text("200")
//    }
//}
//
//@Composable
//fun Button4(question: Preguntas) {
//    var error by remember { mutableStateOf(Color.Unspecified) }
//    Button(onClick = {error = Color.Red},
//        colors = ButtonDefaults.buttonColors(containerColor = error),
//        shape = CutCornerShape(4.dp),
//        border = BorderStroke(
//            width = 2.dp,
//            brush = Brush.horizontalGradient(
//                listOf(
//                    Color.Yellow,
//                    Color.Transparent
//                )
//            )
//        )
//    ) {
//        Text(text = question.respuestas)
//    }
//}