package cat.itb.m78.exercices.MapCompose.P3_Project

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.ktor.websocket.Frame

@Composable
fun ListScreen() {
    Column {
        Frame.Text("List Screen")
        Button({ }) {
            Text("Map")
        }
    }
}