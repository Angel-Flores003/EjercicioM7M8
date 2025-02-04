package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Button3
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.Navigation.Pantalla1
import cat.itb.m78.exercices.Navigation.Screen1
import cat.itb.m78.exercices.Navigation.TicTacToe
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Trivial
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

object Projecte {
    @Serializable
    data object Menu
    @Serializable
    data object Screen1
    @Serializable
    data object Screen2
    @Serializable
    data object Screen3
    @Serializable
    data object Screen4
    @Serializable
    data object Screen5
    @Serializable
    data object Screen6
    @Serializable
    data object Screen7
    @Serializable
    data object Screen8
    @Serializable
    data object Screen9
    @Serializable
    data object Screen10
    @Serializable
    data object Screen11
    @Serializable
    data object Screen12
    @Serializable
    data object Screen13
    @Serializable
    data object Screen14
    @Serializable
    data object Screen15
    @Serializable
    data object Settings
    @Serializable
    data object Result
}

@Composable
fun Projecte() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Projecte.Menu) {
        composable<Projecte.Menu> {
            Menu(
                onScreen1Click = { navController.navigate(Projecte.Screen1) })
        }
        composable<Projecte.Screen1> {
            Screen1 (
                onScreen2Click = { navController.navigate(Projecte.Screen2) })
        }
        composable<Projecte.Screen2> {
            Screen2 (
                onScreen3Click = { navController.navigate(Projecte.Screen3) })
        }
        composable<Projecte.Screen3> {
            Screen3 (
                onScreen4Click = { navController.navigate(Projecte.Screen4) })
        }
        composable<Projecte.Screen4> {
            Screen4 (
                onScreen5Click = { navController.navigate(Projecte.Screen5) })
        }
        composable<Projecte.Screen5> {
            Screen5 (
                onScreen6Click = { navController.navigate(Projecte.Screen6) })
        }
        composable<Projecte.Screen6> {
            Screen6 (
                onScreen7Click = { navController.navigate(Projecte.Screen7) })
        }
        composable<Projecte.Screen7> {
            Screen7 (
                onScreen8Click = { navController.navigate(Projecte.Screen8) })
        }
        composable<Projecte.Screen8> {
            Screen8 (
                onScreen9Click = { navController.navigate(Projecte.Screen9) })
        }
        composable<Projecte.Screen9> {
            Screen9 (
                onScreen10Click = { navController.navigate(Projecte.Screen10) })
        }
        composable<Projecte.Screen10> {
            Screen10 (
                onScreen11Click = { navController.navigate(Projecte.Screen11) })
        }
        composable<Projecte.Screen11> {
            Screen11 (
                onScreen12Click = { navController.navigate(Projecte.Screen12) })
        }
        composable<Projecte.Screen12> {
            Screen12 (
                onScreen13Click = { navController.navigate(Projecte.Screen13) })
        }
        composable<Projecte.Screen13> {
            Screen13 (
                onScreen14Click = { navController.navigate(Projecte.Screen14) })
        }
        composable<Projecte.Screen14> {
            Screen14 (
                onScreen15Click = { navController.navigate(Projecte.Screen15) })
        }
        composable<Projecte.Screen15> {
            Screen15 (
                onResultClick = { navController.navigate(Projecte.Result) })
        }

}

@Composable
fun Menu(onScreen1Click: () -> Unit) {
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
        Button(onClick = onScreen1Click,
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
        Button(onClick = {},
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
fun Screen1(onScreen2Click: () -> Unit) {
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
fun Result() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(200.dp))
        Text("Your Score", fontWeight = FontWeight.Black)
        Text("puntuación")//Cambiar Luego
        Spacer(Modifier.height(250.dp))
        Button(onClick = {},
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
fun Settings() {
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
        Button(onClick = {},
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