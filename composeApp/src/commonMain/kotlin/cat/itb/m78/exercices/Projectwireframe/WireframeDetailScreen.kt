package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun WireframeDetailScreen() { //wireframeId: Long
    val viewModel = viewModel { WireframeViewModel() }
    val wireframe = viewModel.wireframe.value
    WireframeDetailScreen(wireframe)
}

@Composable
fun WireframeDetailScreen(wireframe: List<Wireframe>?) {
    if (wireframe == null) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(wireframe) { wireframe ->
                Row {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Name: " + wireframe.name, fontWeight = FontWeight.Bold)
                        Text("Size: " + wireframe.size)
                        Text("Age: " + wireframe.age)
                        wireframe.funcion?.let { Text("Post: " + it) }
                        Text("Bounty: " + wireframe.bounty.toString() + "$")
                        Spacer(modifier = Modifier.height(10.dp))

                        wireframe.crew?.let { Text("Belongs to the crew: " + it.name) }
                        wireframe.crew?.let { Text("Number of crew members: " + it.tripulantes) }
                        wireframe.crew?.let { Text("Total price: " + it.total_price) }
                        Spacer(modifier = Modifier.height(10.dp))

                        wireframe.fruit?.let { Text("Fruit: " + it.name) }
                        wireframe.fruit?.let {
                            AsyncImage(
                                model = it.Imatge, // Use the Imatge property
                                contentDescription = null
                            )
                        }
                        wireframe.fruit?.let { Text("Roman name: " + it.roman_name) }
                        wireframe.fruit?.let { Text("Type: " + it.type) }
                        wireframe.fruit?.let { Text("Description: " + it.description) }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text("Status: " + wireframe.status)
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}