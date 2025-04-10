package cat.itb.m78.exercices.Prova_M78.P2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Prova2ScreenFaltes(prova2Id: Long) {
    val viewModel = viewModel { Prova2ViewModel() }
    val prova2 = viewModel.prova2.value
    //val faltes = myStudentsQueries.insert("")

    LaunchedEffect(prova2Id){
        viewModel.fetchProva2ById(prova2Id)
    }

    if (prova2 == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
    else
    {

    }
}