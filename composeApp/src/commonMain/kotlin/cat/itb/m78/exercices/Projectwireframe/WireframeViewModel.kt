package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WireframeViewModel : ViewModel() {
    val wireframe = mutableStateOf<List<Wireframe>?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default){
            wireframe.value = WireframeApi().listWireframe()
        }
    }
}