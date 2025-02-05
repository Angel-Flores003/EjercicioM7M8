package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Button3
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.Navigation.MainMenu
import cat.itb.m78.exercices.Navigation.ManualNavViewModel
import cat.itb.m78.exercices.Navigation.Screen
import cat.itb.m78.exercices.Navigation.Screen1
import cat.itb.m78.exercices.Navigation.Screen2
import cat.itb.m78.exercices.Navigation.Screen3Bye
import cat.itb.m78.exercices.Navigation.Screen3Hello
import cat.itb.m78.exercices.State.Message
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Trivial
import org.jetbrains.compose.resources.painterResource

sealed interface Practica {
    object Menu : Practica
    data class Question(val message: String) : Practica
    object Settings : Practica
    object Result : Practica

}

object Projecte {
    @Serializable
    data object Menu
    @Serializable
    data object Question
    @Serializable
    data object Settings
    @Serializable
    data object Result
}

class PracticaViewModel : ViewModel() {
    val screenState = mutableStateOf<Practica>(Practica.Menu)

    fun navigateTo(practica: Practica) {
        screenState.value = practica
    }
}

@Composable
fun Practica() {
    val viewModel = viewModel<PracticaViewModel>()
    val screen by remember { viewModel.screenState }

    when (screen) {
        Practica.Menu -> Menu(
            onSettingsClick = { viewModel.navigateTo(Practica.Settings) },
            onQuestionClick = { viewModel.navigateTo(Practica.Question(it)) }
        )

        Practica.Settings -> Settings(onBackToMenu = { viewModel.navigateTo(Practica.Menu) })
        Practica.Result -> Result(onBackToMenu = { viewModel.navigateTo(Practica.Menu) })
        is Practica.Question -> Question(currentScreen.message,
            onSettingsClick = { viewModel.navigateTo(Practica.Result) })
    }
}

@Composable
fun Menu(
    onSettingsClick: () -> Unit,
    onQuestionClick: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(Res.drawable.Trivial),
            modifier = Modifier.size((200.dp)),
            contentDescription = null
        )
        Button(onClick = onQuestionClick,
            shape = CutCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Green,
                        Color.Magenta
                    )
                )
            )
        ) {
            Text("New Game")
        }
        Button(onClick = onSettingsClick,
            shape = CutCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Magenta,
                        Color.Green
                    )
                )
            )
        ) {
            Text("Settings")
        }
    }
}

@Composable
fun Question(message: String, onSettingsClick: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(10.dp))
        Text("Round 1/10", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(100.dp))
        Text("Question", fontWeight = FontWeight.Black)//Cambiar
        Spacer(Modifier.height(20.dp))
        RowButton1()
        Spacer(Modifier.height(10.dp))
        RowButton2()
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
        Text("Respuesta1")
    }
}

@Composable
fun Button2() {
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
        Text("Respuesta2")
    }
}

@Composable
fun Button3() {
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
        Text("Respuesta3")
    }
}

@Composable
fun Button4() {
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
        Text("Respuesta4")
    }
}

@Composable
fun Result( onBackToMenu: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(200.dp))
        Text("Your Score", fontWeight = FontWeight.Black)
        Text("puntuación")//Cambiar Luego
        Spacer(Modifier.height(250.dp))
        Button(onClick = onBackToMenu,
            shape = CutCornerShape(4.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Green,
                        Color.Magenta
                    )
                )
            )
        ) {
            Text("Back To Menu")
        }
    }
}

@Composable
fun Settings(onBackToMenu: () -> Unit) {
    Column (modifier = Modifier.fillMaxSize()){
        Text("Difficulty", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text("Rounds", fontWeight = FontWeight.Bold)//Añadir 3 botones?
        Spacer(Modifier.height(20.dp))
        Text("Time for round", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(50.dp))
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ){
        Button(onClick = onBackToMenu,
            shape = CutCornerShape(4.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Magenta,
                        Color.Green
                    )
                )
            )
        ) {
            Text("Back To Menu")
        }
    }
}