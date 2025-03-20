package cat.itb.m78.exercices.Api.Estatembassaments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EmbassamentsScreen(){
    val viewModel = viewModel { EmbassamentsViewModel() }
    val embassaments = viewModel.embassaments.value
    EmbassamentsScreen(embassaments)
}

@Composable
fun EmbassamentsScreen(embassaments: List<Embassaments>?) {
    if (embassaments==null){
        CircularProgressIndicator()
    }
    else{
        LazyColumn {
            items(embassaments) { embassament ->
                Column () {
                    Text(embassament.estaci)
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}