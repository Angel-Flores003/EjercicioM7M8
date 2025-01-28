package cat.itb.m78.exercices.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

sealed interface Screen {
    object MainMenu : Screen
    object Screen1 : Screen
    object Screen2 : Screen
    object Screen3Hello : Screen
    object Screen3Bye : Screen
}

class ManualNavViewModel : ViewModel() {
    val screenState = mutableStateOf<Screen>(Screen.MainMenu)

    fun navigateTo(screen: Screen) {
        screenState.value = screen
    }
}

@Composable
fun ManualNav() {
    val viewModel = viewModel<ManualNavViewModel>()
    val screen by remember { viewModel.screenState }

    when (screen) {
        Screen.MainMenu -> MainMenu(
            onScreen1Click = { viewModel.navigateTo(Screen.Screen1) },
            onScreen2Click = { viewModel.navigateTo(Screen.Screen2) },
            onScreen3HelloClick = { viewModel.navigateTo(Screen.Screen3Hello) },
            onScreen3ByeClick = { viewModel.navigateTo(Screen.Screen3Bye) }
        )

        Screen.Screen1 -> Screen1(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
        Screen.Screen2 -> Screen2(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
        Screen.Screen3Hello -> Screen3Hello(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
        Screen.Screen3Bye -> Screen3Bye(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
    }
}

@Composable
fun MainMenu(
    onScreen1Click: () -> Unit,
    onScreen2Click: () -> Unit,
    onScreen3HelloClick: () -> Unit,
    onScreen3ByeClick: () -> Unit
) {
    Column {
        Button(onClick = onScreen1Click) {
            Text("Screen 1")
        }
        Button(onClick = onScreen2Click) {
            Text("Screen 2")
        }
        Button(onClick = onScreen3HelloClick) {
            Text("Screen 3 - Hello")
        }
        Button(onClick = onScreen3ByeClick) {
            Text("Screen 3 - Bye")
        }
    }
}

@Composable
fun Screen1(onBackToMainMenu: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.background(Color.Green).fillMaxSize()
    ){
        Text("Screen 1")
        Button(onClick = onBackToMainMenu) {
            Text("Main Menu")
        }
    }
}

@Composable
fun Screen2(onBackToMainMenu: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color.Red).fillMaxSize()
    ){
        Text("Screen 2")
        Button(onClick = onBackToMainMenu) {
            Text("Main Menu")
        }
    }
}

@Composable
fun Screen3Hello(onBackToMainMenu: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Blue).fillMaxSize()
    ){
        Text("Screen 3")
        Text("Hello")
        Button(onClick = onBackToMainMenu) {
            Text("Main Menu")
        }
    }
}

@Composable
fun Screen3Bye(onBackToMainMenu: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Blue).fillMaxSize()
    ){
        Text("Screen 3")
        Text("Bye")
        Button(onClick = onBackToMainMenu) {
            Text("Main Menu")
        }
    }
}