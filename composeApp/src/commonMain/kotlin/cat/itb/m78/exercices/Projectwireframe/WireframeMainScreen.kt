package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WireframeMainScreen() {
    val viewModel = viewModel { WireframeViewModel() }
    val wireframe = viewModel.wireframe.value
    WireframeScreen(wireframe)

}

@Composable
fun WireframeScreen(wireframe: List<Wireframe>?) {
    if(wireframe==null){
        CircularProgressIndicator()
    } else {
        LazyColumn() {
            items(wireframe) { wireframe ->
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(wireframe.name, fontWeight = FontWeight.Bold)
                        Text(wireframe.funcion)
                        Text(wireframe.bounty.toString())
                        Text(wireframe.crew.name)
                        Text(wireframe.fruit.toString())?: Text("No tiene fruta")
                    }
                }
            }
        }
    }
}
