package cat.itb.m78.exercices.State

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun SayHelloScreen(){
    Button(onClick = {}){
        Text("Say Hello")
    }
    /*var text by remember { mutableSetOf("") }
    TextField(text, onValueChange = {text = it})*/
}