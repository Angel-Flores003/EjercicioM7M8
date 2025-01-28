package cat.itb.m78.exercices.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object Destination{
    @Serializable
    data object HelloWorld
    @Serializable
    data object Welcome
    @Serializable
    data object Resource
    @Serializable
    data object Contact
    @Serializable
    data object MessagesList
    @Serializable
    data object GoodMorningAndNight
    @Serializable
    data object SayHelloScreen
    @Serializable
    data object SecretNumber
    @Serializable
    data object DiceRoller
    @Serializable
    data object Counter
    @Serializable
    data object ShoppingList
    @Serializable
    data object ManualNav
    @Serializable
    data object TicTacToe
    @Serializable
    data object Screen1
    @Serializable
    data object Screen2
    @Serializable
    data object Screen3
}
@Composable
fun LibNavScreenSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Screen1) {
        composable<Destination.Screen1> {
            Screen1(
                navigateToScreen2 = { navController.navigate(Destination.Screen2) },
            )
        }
        composable<Destination.Screen2> {
            Screen2 { navController.navigate(Destination.Screen3(it)) }
        }
        composable<Destination.Screen3> { backStack ->
            val message = backStack.toRoute<Destination.Screen3>().message
            Screen3(message)
        }
    }
}