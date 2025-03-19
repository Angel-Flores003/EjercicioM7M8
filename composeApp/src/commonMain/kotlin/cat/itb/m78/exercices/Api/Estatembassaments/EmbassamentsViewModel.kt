package cat.itb.m78.exercices.Api.Estatembassaments

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmbassamentsViewModel : ViewModel() {
    val embassaments = mutableStateOf<List<Embassaments>?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default){
            embassaments.value = EmbassamentsApi.listEmbassaments()
        }
    }
}