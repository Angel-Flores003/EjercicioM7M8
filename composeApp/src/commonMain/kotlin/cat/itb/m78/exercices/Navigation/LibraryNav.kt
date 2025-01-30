package cat.itb.m78.exercices.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object MainMenu
    @Serializable
    data object Screen1
    @Serializable
    data object Screen2
    @Serializable
    data object Screen3Hello
    @Serializable
    data object Screen3Bye
}

@Composable
fun LibNavScreenSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.MainMenu) {
        composable<Destination.MainMenu> {
            MainMenu(
                onScreen1Click = { navController.navigate(Destination.Screen1) },
                onScreen2Click = { navController.navigate(Destination.Screen2) },
                onScreen3HelloClick = { navController.navigate(Destination.Screen3Hello) },
                onScreen3ByeClick = { navController.navigate(Destination.Screen3Bye) }
            )
        }
        composable<Destination.Screen1> {
            Screen1 (
                onBackToMainMenu = { navController.navigate(Destination.MainMenu) })
        }
        composable<Destination.Screen2> {
            Screen2 (
                onBackToMainMenu = { navController.navigate(Destination.MainMenu) })
        }
        composable<Destination.Screen3Hello> {
            Screen3Hello (
                onBackToMainMenu = { navController.navigate(Destination.MainMenu) })
        }
        composable<Destination.Screen3Bye> {
            Screen3Bye (
                onBackToMainMenu = { navController.navigate(Destination.MainMenu) })
        }
    }
}

//@Composable
//fun LibraryNav() {
//    val viewModel = viewModel<ManualNavViewModel>()
//    val screen by remember { viewModel.screenState }
//
//    when (screen) {
//        Screen.MainMenu -> MainMenu(
//            onScreen1Click = { viewModel.navigateTo(Screen.Screen1) },
//            onScreen2Click = { viewModel.navigateTo(Screen.Screen2) },
//            onScreen3HelloClick = { viewModel.navigateTo(Screen.Screen3Hello) },
//            onScreen3ByeClick = { viewModel.navigateTo(Screen.Screen3Bye) }
//        )
//
//        Screen.Screen1 -> Screen1(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
//        Screen.Screen2 -> Screen2(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
//        Screen.Screen3Hello -> Screen3Hello(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
//        Screen.Screen3Bye -> Screen3Bye(onBackToMainMenu = { viewModel.navigateTo(Screen.MainMenu) })
//    }
//}