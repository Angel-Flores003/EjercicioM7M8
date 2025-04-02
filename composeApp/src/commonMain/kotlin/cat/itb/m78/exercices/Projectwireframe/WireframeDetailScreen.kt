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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage as AsyncImage1

@Composable
fun WireframeDetailScreen(wireframeId: Long) {
    val viewModel = viewModel<WireframeViewModel>()
    val onewireframe = viewModel.onewireframe.value

    // Llamada a fetchWireframeById cuando wireframeId cambia
    LaunchedEffect(wireframeId) {
        viewModel.fetchWireframeById(wireframeId)
    }

    if (onewireframe == null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator() // Cargando mientras se obtiene el wireframe
        }
    } else {
        // Aquí mostramos solo un ítem de la lista
        Row {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Name: " + onewireframe.name, fontWeight = FontWeight.Bold)
                Text("Size: " + onewireframe.size)
                Text("Age: " + onewireframe.age)  // Aquí debería ser `onewireframe.age` y no `wireframe.age`
                onewireframe.funcion?.let { Text("Post: " + it) }
                Text("Bounty: " + onewireframe.bounty.toString() + "$")
                Spacer(modifier = Modifier.height(10.dp))

                onewireframe.crew?.let { Text("Belongs to the crew: " + it.name) }
                onewireframe.crew?.let { Text("Number of crew members: " + it.tripulantes) }
                Spacer(modifier = Modifier.height(10.dp))

                onewireframe.fruit?.let { Text("Fruit: " + it.name) }
                onewireframe.fruit?.let {
                    AsyncImage1(
                        model = it.Imatge, // Usar la propiedad Imatge
                        contentDescription = null
                    )
                }
                onewireframe.fruit?.let { Text("Roman name: " + it.roman_name) }
                onewireframe.fruit?.let { Text("Type: " + it.type) }
                onewireframe.fruit?.let { Text("Description: " + it.description) }
                Spacer(modifier = Modifier.height(15.dp))
                Text("Status: " + onewireframe.status)
                //Spacer(modifier = Modifier.height(25.dp))
            }
        }
    }
}