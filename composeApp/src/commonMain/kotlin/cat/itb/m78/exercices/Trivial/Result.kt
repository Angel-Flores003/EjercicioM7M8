package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Result(
    onBackToMenu: () -> Unit,
    score: Int,
//    total: Int
    ) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize(),
    ){
        Spacer(Modifier.height(200.dp))
        Text(text = "Your Score: ", fontWeight = FontWeight.Black)
        Text(text = "$score de 15 preguntes", style = MaterialTheme.typography.bodyLarge) //$total
        Spacer(Modifier.height(250.dp))
        Button(onClick = onBackToMenu,
            shape = CutCornerShape(4.dp),
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
            Text("Back To Menu")
        }
    }
}