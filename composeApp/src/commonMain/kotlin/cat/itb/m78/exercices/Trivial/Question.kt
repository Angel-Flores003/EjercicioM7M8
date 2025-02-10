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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Preguntas(
    val text: String,
    val respuestas: List<String>,
    val correct: String
)

@Composable
fun TrivialGame() {
    val questions = remember {
        mutableStateListOf(
            Preguntas("¿Cuál es la capital de Francia?", listOf("París", "Madrid", "Berlín", "Roma"), "París"),
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
            Preguntas( "¿Cuando se creó minecraft?", listOf("2002", "2020", "2011", "2035"), "2011")
        )
    }.also { it.shuffle() }

    var currentIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    if (currentIndex < questions.size) {
        val currentQuestion = questions[currentIndex]
        QuestionScreen(
            question = currentQuestion,
            onAnswerSelected = { selected ->
                if (selected == currentQuestion.correct) {
                    score++
                }
                if (currentIndex < questions.size - 1) {
                    currentIndex++
                } else {
                    showResult = true
                }
            },
            onTimeUp = {
                if (currentIndex < questions.size - 1) {
                    currentIndex++
                } else {
                    showResult = true
                }
            }
        )
    } else if (showResult) {
        Result(score, questions.size)
    }
}

@Composable
fun QuestionScreen(question: Preguntas, onAnswerSelected: (String) -> Unit, onTimeUp: () -> Unit) {
    var timeLeft by remember { mutableStateOf(10) }  // 10 segundos por pregunta
    val scope = rememberCoroutineScope()

    LaunchedEffect(question) {  // Reiniciar temporizador con cada pregunta
        timeLeft = 10
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
        onTimeUp()  // Cambia la pregunta si el tiempo se acaba
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = question.text, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Tiempo restante: $timeLeft s", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(20.dp))

        val shuffledOptions = question.options.shuffled()

        shuffledOptions.forEach { answer ->
            Button(
                onClick = {
                    onAnswerSelected(answer)
                    scope.launch { delay(500) } // Pequeña pausa antes de cambiar
                },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text(text = answer)
            }
        }
    }
}




@Composable
fun Question(
    message: String,
    onSettingsClick: () -> Unit,
    question: Preguntas,
    onAnswerSelected: (String) -> Unit,
    onTimeUp: () -> Unit
//    counterround: Int,
//    onIncreaserCounterRound: () -> Unit
) {
    var timeLeft by remember { mutableStateOf(10) }  // 10 segundos por pregunta
    val scope = rememberCoroutineScope()

    LaunchedEffect(question) {  // Reiniciar temporizador con cada pregunta
        timeLeft = 10
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
        onTimeUp()  // Cambia la pregunta si el tiempo se acaba
    }
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