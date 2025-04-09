package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage


@Composable
fun WireframeMainScreen() {
    val navController = rememberNavController() // Crear NavController
    val viewModel = viewModel { WireframeViewModel() }

     NavHost(navController = navController, startDestination = "main_screen") {
        // Pantalla principal
        composable("main_screen") {
            WireframeScreen(
                wireframe = viewModel.otherlist.value,
                newFilter = viewModel.otherlistfilter.value,
                filterList = viewModel::filterList,
                onShowHome = { viewModel.toggleFavorites(false) },
                onShowFavorites = { viewModel.toggleFavorites(true) },
                fetchWireframeById = { id ->
                    viewModel.fetchWireframeById(id)
                    navController.navigate("detail_screen/$id") // Navegar a la pantalla de detalle con el id
                }
            )
        }

        // Pantalla de detalle (WireframeDetailScreen)
        composable("detail_screen/{wireframeId}") { backStackEntry ->
            val wireframeId = backStackEntry.arguments?.getString("wireframeId")?.toLongOrNull()
            wireframeId?.let {
                WireframeDetailScreen(wireframeId = it)
            }
        }
    }
}

@Composable
fun WireframeScreen(
    wireframe: List<Wireframe>?,
    newFilter: String,
    filterList: (String) -> Unit,
    onShowHome: () -> Unit,
    onShowFavorites: () -> Unit,
    fetchWireframeById: (Long) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    NavigationBarItem(
                        onClick = { onShowHome() },
                        selected = true,
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        onClick = { onShowFavorites() },
                        selected = false,
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
                        label = { Text("Favorites") }
                    )
                },
            )
        }
    ) { innerPadding ->
        if (wireframe == null) {
            CircularProgressIndicator(modifier = Modifier.padding(innerPadding))
        } else {
            Column(modifier = Modifier.padding(innerPadding)) {
                TextField(
                    value = newFilter,
                    label = { Text("Search") },
                    onValueChange = filterList
                )
                Spacer(modifier = Modifier.height(15.dp))

                LazyColumn() {
                    items(wireframe) { wireframe ->
                        Row {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    "Name: ${wireframe.name}",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.clickable { fetchWireframeById(wireframe.id) }
                                )
                                wireframe.funcion?.let { Text("Post: $it") }
                                Text("Bounty: ${wireframe.bounty}$")
                                wireframe.crew?.let { Text("Belongs to the crew: ${it.name}") }
                                wireframe.fruit?.let { Text("Fruit: ${it.name}") }
                                wireframe.fruit?.let {
                                    AsyncImage(
                                        model = it.Imatge,
                                        contentDescription = null
                                    )
                                }
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}





//
//@Composable
//fun WireframeMainScreen() {
//    val viewModel = viewModel { WireframeViewModel() }
//    val wireframe = viewModel.wireframe.value
//    WireframeScreen(
//        viewModel.otherlist.value,
//        viewModel.otherlistfilter.value,
//        viewModel::filterList,
//        onShowHome = { viewModel.toggleFavorites(false) },
//        onShowFavorites = { viewModel.toggleFavorites(true) },
//        viewModel::fetchWireframeById
//    )
//}
//
//@Composable
//fun WireframeScreen(
//    wireframe: List<Wireframe>?,
//    newFilter: String,
//    filterList: (String) -> Unit,
//
//    onShowHome: () -> Unit,
//    onShowFavorites: () -> Unit,
//    fetchWireframeById: (Long) -> Unit
//) {
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                actions = {
//                    NavigationBarItem(
//                        onClick = { onShowHome() },
//                        selected = true,
//                        //selected = false,
//                        icon = {
//                            Icon(
//                                Icons.Filled.Home,
//                                contentDescription = "Home"
//                            )
//                        },
//                        label = {
//                            Text(text = "Home")
//                        }
//                    )
//                    NavigationBarItem(
//                        onClick = { onShowFavorites() },
//                        selected = false,
//                        icon = {
//                            Icon(
//                                Icons.Filled.Favorite,
//                                contentDescription = "Favoriites"
//                            )
//                        },
//                        label = {
//                            Text(text = "Favorites")
//                        }
//                    )
//                },
//            )
//        },
//    ) { innerPadding ->
//        if (wireframe == null) {
//            CircularProgressIndicator(modifier = Modifier.padding(innerPadding))
//        } else {
//            Column(
//                modifier = Modifier.padding(innerPadding)
//            ) {
//                TextField(
//                    value = newFilter,
//                    label = { Text("Search") },
//                    onValueChange = filterList
//                )
//                Spacer(modifier = Modifier.height(15.dp))
//
//                LazyColumn() {
//                    items(wireframe) { wireframe ->
//                        Row {
//                            Column(modifier = Modifier.weight(1f)) {
//                                Text("Name: " + wireframe.name, fontWeight = FontWeight.Bold, modifier = Modifier.clickable{ fetchWireframeById(wireframe.id) })
//                                wireframe.funcion?.let { Text("Post: " + it) }
//                                Text("Bounty: " + wireframe.bounty.toString() + "$")
//                                wireframe.crew?.let { Text("Belongs to the crew: " + it.name) }
//                                wireframe.fruit?.let { Text("Fruit: " + it.name) }
//                                wireframe.fruit?.let {
//                                    AsyncImage(
//                                        model = it.Imatge, // Use the Imatge property
//                                        contentDescription = null
//                                    )
//                                }
//                                Spacer(modifier = Modifier.height(15.dp))
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}