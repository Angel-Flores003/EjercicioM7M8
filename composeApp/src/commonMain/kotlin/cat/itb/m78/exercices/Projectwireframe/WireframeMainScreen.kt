package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun WireframeMainScreen() {
    val viewModel = viewModel { WireframeViewModel() }
    val wireframe = viewModel.wireframe.value
    WireframeScreen(viewModel.otherlist.value, viewModel.otherlistfilter.value, viewModel::filterList)
    //WireframeScreen(wireframe, viewModel.otherlistfilter.value, viewModel::filterList)
}

@Composable
fun WireframeScreen(
    wireframe: List<Wireframe>?,
    newFilter: String,
    filterList: (String) -> Unit
    ) {
    if(wireframe==null){
        CircularProgressIndicator()
    } else {
        Column {
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
                            Text("Name: " + wireframe.name, fontWeight = FontWeight.Bold)
                            wireframe.funcion?.let { Text("Post: " + it) }
                            Text("Bounty: " + wireframe.bounty.toString() + "$")
                            wireframe.crew?.let { Text("Belongs to the crew: " + it.name) }
                            wireframe.fruit?.let { Text("Fruit: " + it.name) }
                            wireframe.fruit?.let {
                                AsyncImage(
                                    model = it.Imatge, // Use the Imatge property
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