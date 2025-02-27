package cat.itb.m78.exercices.ExamenM078

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.Navigation.ManualNavViewModel
import cat.itb.m78.exercices.Trivial.Practica
import cat.itb.m78.exercices.Trivial.PracticaViewModel
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Calculator_icon
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

//sealed interface Calculadora {
//    object CalculatorApp : Calculadora
//    object Resultado : Calculadora
//}

//class PantallasViewModel : ViewModel() {
//    val pantalla = mutableStateOf<Calculadora>(Calculadora.CalculatorApp)
//
//    fun navigateTo(screen: Calculadora) {
//        pantalla.value = screen
//    }
//}

object Calculadora {
    @Serializable
    data object CalculatorApp
    @Serializable
    data object Resultado
}

@Composable
fun PantallasViewModel() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Calculadora.CalculatorApp) {
        composable<Calculadora.CalculatorApp> {
            Examen(ongoResult = {navController.navigate(Calculadora.Resultado)})
        }
    }
}

//@Composable
//fun Calculadoraviewmodel() {
//    val viewModel = ViewModel<PantallasViewModel>()
//    val screen = viewModel.pantalla.value
//
//    when (screen) {
//        Calculadora.CalculatorApp -> CalculatorApp( onClickEnd = { viewModel.navigateTo(Calculadora.CalculatorApp)})
//    //onClickEnd = { result ->
////            viewModel.setNum(Num)
////            viewModel.navigateTo(Calculadora.Resultado)})
//    }
//}

class CalculadoraViewModel : ViewModel() {
    var num = mutableStateOf(0)
    var text = mutableStateOf(0)

    fun Calculate() {
    }
    fun onClickSumar() {
        num.value = (num.value + text.value)
    }
    fun onClickRestar() {
        num.value = (num.value - text.value)
    }
    fun onClickMultiplicar() {
        num.value = (num.value * text.value)
    }
    fun onClickDividi() {
        num.value =(num.value % text.value)
    }
//    fun changeText(newText: String)
//    {
//        text.value = newText
//    }
}

@Composable
fun CalculatorApp(ongoResult: () -> Unit){ //onClickEnd: (Int) -> Unit
    val viewModel = viewModel { CalculadoraViewModel() }
    MyCalculatorApp(
        viewModel::onClickSumar,
        viewModel::onClickRestar,
        viewModel::onClickMultiplicar,
        viewModel::onClickDividi,
        ongoResult
    )
//    {
//        onClickEnd(viewModel.num.value)
//    }
}

@Composable
fun MyCalculatorApp(
    onClickSumar: () -> Unit,
    onClickRestar: () -> Unit,
    onClickMultiplicar: () -> Unit,
    onClickDividi: () -> Unit,
    ongoResult: () -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(color = Color.Yellow)
    ){
        var num by mutableStateOf(0)
        var text by remember { mutableStateOf("") }

        Text("${num}", style = MaterialTheme.typography.bodyLarge)
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(color = Color.White).padding(5.dp)
        ){
            Row {
                Button(onClick = onClickSumar){
                    Text("+")
                }
                Spacer(Modifier.width(5.dp))
                Button(onClick = onClickRestar){
                    Text("-")
                }
                Spacer(Modifier.width(5.dp))
                Button(onClick = onClickMultiplicar){
                    Text("*")
                }
                Spacer(Modifier.width(5.dp))
                Button(onClick = onClickDividi){
                    Text("/")
                }
                Spacer(Modifier.width(5.dp))
            }
            OutlinedTextField(text,
                label = { Text("") },
                onValueChange = {
                    text = it
                })
            Row {
                OutlinedButton(onClick = ongoResult) {
                    Text("End")
                }
                Spacer(Modifier.width(7.dp))
                Button(onClick = {}) {
                    Text("Calculate")
                }
            }
        }
    }
}

@Composable
fun Resultado() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(color = Color.Yellow)
    ){
        Text("The final result is")
        Text("")//"$result"
        Image(
            painter = painterResource(Res.drawable.Calculator_icon),
            modifier = Modifier.size((300.dp)),
            contentDescription = null
        )
    }
}