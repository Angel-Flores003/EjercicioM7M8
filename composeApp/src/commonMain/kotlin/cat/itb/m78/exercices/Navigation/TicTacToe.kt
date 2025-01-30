package cat.itb.m78.exercices.Navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

object TicTacToe {
    @Serializable
    data object Pantalla1
    @Serializable
    data object Pantalla2
    @Serializable
    data object Pantalla3
}

@Composable
fun TicTacToe() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TicTacToe.Pantalla1) {
        composable<TicTacToe.Pantalla1> {
            Pantalla1(
                onPantalla2Click = {navController.navigate(TicTacToe.Pantalla2)})
        }
        composable<TicTacToe.Pantalla2> {
            Pantalla2(
                onPantalla3Click = {navController.navigate(TicTacToe.Pantalla3)})
        }
        composable<TicTacToe.Pantalla3> {
            Pantalla3(
                onBackToPantalla1 = {navController.navigate(TicTacToe.Pantalla1)})
        }
    }
}

@Composable
fun Pantalla1 ( onPantalla2Click: () -> Unit ) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Button(onClick = onPantalla2Click,
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Green,
                        Color.Magenta
                    )
                )
            )) {
            Text("Start", color = Color.White)
        }
    }
}

@Composable
fun Pantalla2 ( onPantalla3Click: () -> Unit ) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        SingleRow()
        SingleRow()
        SingleRow()
        }
}

@Composable
fun SingleRow () {
    Row {
        CreateButton()
        CreateButton()
        CreateButton()
    }
}

@Composable
fun CreateButton () {
    var boolean = true
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(
        containerColor = Color.Cyan)
    ) {
        Text("", color = Color.White)
    }
    fun Bool (boolean: Boolean) {
        if (boolean == true) {

        }
        else {

        }
    }
}

@Composable
fun List<List<Boolean?>>.toMutableMatrix(): List<MutableList<Boolean?>> {
    return map { it.toMutableList() }
}

@Composable
fun Pantalla3 ( onBackToPantalla1: () -> Unit ) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text("The winer is ")
        Button(onClick = onBackToPantalla1) {
            Text("Play again")
        }
    }
}