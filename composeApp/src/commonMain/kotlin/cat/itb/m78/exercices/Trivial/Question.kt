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

val questions = listOf(Preguntas("¿Cuál es la capital de Francia?", listOf("Berlín", "Madrid", "París", "Roma"), "París"),//3
    Preguntas("¿Cuánto es 5 x 6?", listOf("11", "25", "56", "30"), "30"),//4
    Preguntas("¿Quién escribió 'Don Quijote'?", listOf("Shakespeare", "Cervantes", "García Márquez", "Borges"),"Cervantes"),//2
    Preguntas( "¿Cuál es la evolución de Dunsparce?", listOf("Dudunsparce", "Serperior", "Flygon", "Vivillon"), "Dudunsparce"),//1
    Preguntas( "¿Cuántas horas debería dormir un adulto?", listOf("3", "8-10", "7-9", "Domrir es de debiles"), "7-9"),//3
    Preguntas( "¿Cual es el animal volador más rápido?", listOf("Kuervo", "Colibrí", "Halcón peregrino", "Aguila"), "Halcón peregrino"),//3
    Preguntas( "¿Cuántos continentes hay?", listOf("5", "7", "10", "3"), "7"),//2
    Preguntas( "¿Cuantos huesos tiene el cuerpo humano?", listOf("169", "200", "201", "206"), "206"),//4
    Preguntas( "Stop Gambling", listOf("¿Porque?", "Todas son correctas", "No", "Nunca"), "Todas son correctas"),//2
    Preguntas( "¿Quien dijo esta frase? 'Soy el unico, que decide'", listOf("Escanor", "Asta", "Hinata", "L"), "Escanor"),//1
    Preguntas( "¿Cuantos dias tiene un año natural?", listOf("365", "366", "360", "370"), "365"),//1
    Preguntas( "¿Cuantos meses tienen 30 dias?", listOf("12", "4", "11", "1"), "11"),//3
    Preguntas( "¿Qué dia se dijo esta frase? 'Si ayer fuese mañana, hoy seria viernes'", listOf("viernes", "Sabado", "Domingo", "Jueves"), "Domingo"),//3
    Preguntas( "¿Son mejores los perros o los gatos?", listOf("Los Gatos", "Los perros", "Prefiero los hamsters", "Cada uno tiene sus cosas"), "Cada uno tiene sus cosas"),//4
    Preguntas( "¿Cuando se creó minecraft?", listOf("2002", "2011", "2020", "2035"), "2011"))//2

class QuestionViewModel : ViewModel(){
    var i by mutableStateOf(0)
    var question by mutableStateOf(questions[i])
    val counter = mutableStateOf(1)
    val correct = mutableStateOf(0)

    fun onAnswerSelected(selected: String){
        if (i < questions.size - 1)
        {
            i++
            question = questions[i]
            counter.value++
            //if(question)
            {

            }
        }
    }
}

@Composable
fun Question(){
    val viewModel = viewModel { QuestionViewModel() }
    Question(viewModel.question, {}, viewModel::onAnswerSelected, viewModel.counter.value)
}

@Composable
fun Question(
    question: Preguntas,
    onResultShow: () -> Unit,
    onAnswerSelected: (String) -> Unit,
    counter: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(10.dp))
        Text("Round ${counter}/15", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(200.dp))
        Text(text = question.text, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ){
        Row (modifier = Modifier.fillMaxWidth() ){
            Button(onClick = { onAnswerSelected(question.respuestas[0]) },
                shape = CutCornerShape(4.dp),
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Red
                        )
                    )
                ),
                modifier = Modifier.weight(0.5f)
            ) {
                Text(question.respuestas[0])
            }
            Spacer(Modifier.width(50.dp))
            Button(onClick = { onAnswerSelected(question.respuestas[1]) },
                shape = CutCornerShape(4.dp),
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Green,
                            Color.Transparent
                        )
                    )
                ),
                modifier = Modifier.weight(0.5f)
            ) {
                Text(question.respuestas[1])
            }
        }
        Spacer(Modifier.height(25.dp))
        Row (modifier = Modifier.fillMaxWidth() ){
            Button(onClick = { onAnswerSelected(question.respuestas[2]) },
                shape = CutCornerShape(4.dp),
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Cyan
                        )
                    )
                ),
                modifier = Modifier.weight(0.5f)
            ) {
                Text(question.respuestas[2])
            }
            Spacer(Modifier.width(50.dp))
            Button(onClick = { onAnswerSelected(question.respuestas[3]) },
                shape = CutCornerShape(4.dp),
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Yellow,
                            Color.Transparent
                        )
                    )
                ),
                modifier = Modifier.weight(0.5f)
            ) {
                Text(question.respuestas[3])
            }
        }
    }
}