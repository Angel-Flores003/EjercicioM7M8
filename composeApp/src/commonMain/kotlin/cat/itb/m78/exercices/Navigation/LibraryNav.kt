package cat.itb.m78.exercices.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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