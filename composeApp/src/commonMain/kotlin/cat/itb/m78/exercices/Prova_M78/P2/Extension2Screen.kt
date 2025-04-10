package cat.itb.m78.exercices.Prova_M78.P2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun Extension2ScreenList() {
    val viewModel = viewModel { Prova2ViewModel() }
    val extension2 = viewModel.prova2.value

    Prova2Extension2Screen(
        viewModel.otherlist.value,
        viewModel.otherlistfilter.value,
        viewModel::fetchProva2ById
    )
}
@Composable
fun Prova2Extension2Screen(
    prova2: List<Prova2>?,
    value1: String,
    fetchProva2ById: (Long) -> Unit
    ) {
    if (prova2 == null) {
        CircularProgressIndicator()
    } else {
        LazyColumn() {
            items(prova2) { prova2 ->
                Row {
                    Column(
                        modifier = Modifier.weight(1f)
                            .padding(10.dp)
                    ) {
                        Text(
                            prova2.name + prova2.surnames,
                            modifier = Modifier.clickable { fetchProva2ById(prova2.id) },
                            fontWeight = FontWeight.Bold
                        )
                        Text(prova2.email + Icon(Icons.Filled.Email, contentDescription = "Email"))
                        AsyncImage(
                            model = prova2.photo,
                            contentDescription = null
                        )
                        Text("Faltes:" + prova2.countfaltes.toString())
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}