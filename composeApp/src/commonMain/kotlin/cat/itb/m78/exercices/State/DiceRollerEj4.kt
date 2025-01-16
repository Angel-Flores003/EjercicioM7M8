package cat.itb.m78.exercices.State

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.generatedFace
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiceRoller()
{
    val painter = painterResource(Res.drawable.tapestry)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter,
                contentScale = ContentScale.FillBounds
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(Res.drawable.title),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null
        )
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        Button(onClick = {
            //if ()
            scope.launch {
                snackbarHostState.showSnackbar("JACKPOT!")
            }
            /*Scaffold(
                snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState)
                },
            ){ padding ->
                Button(modifier = Modifier.padding(padding), onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Hello!")
                    }
                }){
                    Text("Say hello")
                }
            }*/
        }
            , modifier = Modifier.fillMaxWidth()) {
            Text("ROLL THE DICE")
        }
    }
}