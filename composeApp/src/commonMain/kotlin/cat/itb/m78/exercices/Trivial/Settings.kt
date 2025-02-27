package cat.itb.m78.exercices.Trivial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Settings(onBackToMenu: () -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize(),
        ){
        Spacer(Modifier.height(10.dp))
        Row {
            Text("Difficulty", fontWeight = FontWeight.Bold)
            Spacer(Modifier.width((5.dp)))
            Button(onClick = {},
                shape = CutCornerShape(4.dp),
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
                Text("Easy")
            }
            Spacer(Modifier.width((5.dp)))
            Button(onClick = {},
                shape = CutCornerShape(4.dp),
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
                Text("Normal")
            }
            Spacer(Modifier.width((5.dp)))
            Button(onClick = {},

                shape = CutCornerShape(4.dp),
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
                Text("Hard")
            }
        }
        Spacer(Modifier.height(10.dp))
        Row {
            Text("Rounds", fontWeight = FontWeight.Bold)
            Spacer(Modifier.width((5.dp)))
            Button(onClick = {},
                shape = CutCornerShape(4.dp),
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
                Text("5")
            }
            Spacer(Modifier.width((5.dp)))
            Button(onClick = {},
                shape = CutCornerShape(4.dp),
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
                Text("10")
            }
            Spacer(Modifier.width((5.dp)))
            Button(onClick = {},

                shape = CutCornerShape(4.dp),
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
                Text("15")
            }
        }
        Spacer(Modifier.height(20.dp))
        Text("Time for round", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(50.dp))
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ){
        Button(onClick = onBackToMenu,
            shape = CutCornerShape(4.dp),
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
            Text("Back To Menu")
        }
    }
}