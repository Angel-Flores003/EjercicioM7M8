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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.Navigation.MainMenu
import cat.itb.m78.exercices.Navigation.ManualNavViewModel
import cat.itb.m78.exercices.Navigation.Screen
import cat.itb.m78.exercices.Navigation.Screen1
import cat.itb.m78.exercices.Navigation.Screen2
import cat.itb.m78.exercices.State.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.Serializable
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Trivial
import org.jetbrains.compose.resources.painterResource

sealed interface Practica {
    object Menu : Practica
    object Question : Practica
    //data class Question(val message: String) : Practica
    object Settings : Practica
    object Result : Practica

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
    val screen = viewModel.screenState.value

    when (screen) {
        Practica.Menu -> Menu(
            onSettingsClick = { viewModel.navigateTo(Practica.Settings) },
            onQuestionClick = {viewModel.navigateTo(Practica.Question)}
        )

        Practica.Settings -> Settings(onBackToMenu = { viewModel.navigateTo(Practica.Menu) })
        Practica.Result -> Result(onBackToMenu = { viewModel.navigateTo(Practica.Menu) })
        Practica.Question -> Question(gotoResults = {viewModel.navigateTo(Practica.Result)})
    }
}