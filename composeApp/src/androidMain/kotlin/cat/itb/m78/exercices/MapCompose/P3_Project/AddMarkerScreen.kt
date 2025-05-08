package cat.itb.m78.exercices.MapCompose.P3_Project

import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun addMarkerScreen() {
    var text by remember { mutableStateOf("") }
    var bigtext by remember { mutableStateOf("") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ){

        Spacer(Modifier.height(125.dp))
        OutlinedTextField(text,
            label = { Text("Title") },
            onValueChange = {
                text = it
            })
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(bigtext,
            label = { Text("Description") },
            onValueChange = {
                bigtext = it
            })
        Spacer(Modifier.height(20.dp))
        //[UIImage imageNamed:@"photo_camera"]
        Spacer(Modifier.height(20.dp))
        Row {
            Button(onClick = {}
            ) {
                Text("Add")
            }
            Spacer(Modifier.width(10.dp))
            Button(onClick = {}
            ) {
                Text("Add Last Photo")
            }
        }

        Spacer(Modifier.height(10.dp))
    }
}