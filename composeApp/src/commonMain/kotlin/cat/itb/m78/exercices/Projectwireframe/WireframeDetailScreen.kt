package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage as AsyncImage1

@Composable
fun WireframeDetailScreen(wireframeId: Long) {
    val viewModel = viewModel<WireframeViewModel>()
    val onewireframe = viewModel.onewireframe.value
    var checked by remember { mutableStateOf(false) }

    // Llamada a fetchWireframeById cuando wireframeId cambia
    LaunchedEffect(wireframeId) {
        viewModel.fetchWireframeById(wireframeId)
    }

    if (onewireframe == null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
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
                Text("Age: " + onewireframe.age)
                onewireframe.funcion?.let { Text("Post: " + it) }
                Text("Bounty: " + onewireframe.bounty.toString() + "$")
                Spacer(modifier = Modifier.height(10.dp))

                onewireframe.crew?.let { Text("Belongs to the crew: " + it.name) }
                onewireframe.crew?.let { Text("Number of crew members: " + it.tripulantes) }
                Spacer(modifier = Modifier.height(10.dp))

                onewireframe.fruit?.let { Text("Fruit: " + it.name) }
                onewireframe.fruit?.let {
                    AsyncImage1(
                        model = it.Imatge,
                        contentDescription = null
                    )
                }
                onewireframe.fruit?.let { Text("Roman name: " + it.roman_name) }
                onewireframe.fruit?.let { Text("Type: " + it.type) }
                onewireframe.fruit?.let { Text("Description: " + it.description) }
                Spacer(modifier = Modifier.height(15.dp))
                Text("Status: " + onewireframe.status)
            }
            Column {
                IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    Icon(

                        if (checked) Icons.Default.Favorite
                        else Icons.Default.FavoriteBorder
                        ,
                        contentDescription =
                            if (checked) "Añadir a marcadores"
                            else "Quitar de marcadores",
                        tint = Color(0xFFF00000)
                    )
                }
            }
        }
    }
}