package cat.itb.m78.exercices.MapCompose.P3_Project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

object ProjectScreens {
    @Serializable
    data object Map

    @Serializable
    data object List
}

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("map") }
    val navController = rememberNavController()

    DrawerMenu(
        onMapClick = { navController.navigate(ProjectScreens.Map) },
        onListClick = { navController.navigate(ProjectScreens.List) }
    ) {
        NavHost(navController = navController, startDestination = ProjectScreens.Map) {
            composable<ProjectScreens.Map> {
                MapScreen(
                    //onListClick = { navController.navigate(ProjectScreens.List) }
                )
            }
            composable<ProjectScreens.List> {
                ListScreen(
                    //onMapClick = { navController.navigate(ProjectScreens.Map) }
                )
            }
        }
    }
}