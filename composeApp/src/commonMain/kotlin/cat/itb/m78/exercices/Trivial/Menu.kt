package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.Trivial
import org.jetbrains.compose.resources.painterResource

@Composable
fun Menu(
    onSettingsClick: () -> Unit,
    onQuestionClick: () -> Unit
) {
    var text by remember{ mutableStateOf("") }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(Res.drawable.Trivial),
            modifier = Modifier.size((200.dp)),
            contentDescription = null
        )
        Button(onClick = onQuestionClick,
            shape = CutCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Green,
                        Color.Magenta
                    )
                )
            )
        ) {
            Text("New Game")
        }
        Button(onClick = onSettingsClick,
            shape = CutCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Magenta,
                        Color.Green
                    )
                )
            )
        ) {
            Text("Settings")
        }
    }
}