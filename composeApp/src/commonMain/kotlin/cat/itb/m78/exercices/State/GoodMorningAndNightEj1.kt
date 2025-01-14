package cat.itb.m78.exercices.State

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import co.touchlab.kermit.Message

data class Message(val text: String)
@Composable
fun GoodMorningAndNight() {
    var message by remember { mutableStateOf("Good ?!") }
    Column {
        Text(text = message)
        Button(onClick = {
            message = "Good Morning"
        }) {
            Text("Morning")
        }
        Button(onClick = {
            message = "Good Night"
        }) {
            Text("Night")
        }

        Column(modifier = Modifier.fillMaxWidth().background(Color.Black)) {
            Text(color = Color.White, text = message)
            Button(onClick = {
                message = "Good Morning!"
            }) {
                Text("Morning")
            }
            Button(onClick = {
                message = "Good Night!"
            }) {
                Text("Night")
            }
        }

        Column(modifier = Modifier.fillMaxSize().background(Color.Green)) {
            Text(color = Color.Blue, text = message)
            Button(onClick = {
                message = "Good Morning!"
            }) {
                Text("Morning")
            }
            Button(onClick = {
                message = "Good Night!"
            }) {
                Text("Night")
            }
        }

    }
}