package cat.itb.m78.exercices.State

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun GoodMorningAndNight(){
    Column {
        Text("Good ?!")
        //var Text = remember { mutableSetOf("Morning") }
        Button(onClick = {}){
            Text("Morning")
        }
        Button(onClick = {}){
            Text("Night")
        }
    }
}