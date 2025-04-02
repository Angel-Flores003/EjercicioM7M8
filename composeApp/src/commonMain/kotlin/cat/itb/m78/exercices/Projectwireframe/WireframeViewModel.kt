package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WireframeViewModel : ViewModel() {
    val wireframe = mutableStateOf<List<Wireframe>?>(null)
    val onewireframe = mutableStateOf<Wireframe?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            wireframe.value = WireframeApi().listWireframe()
        }
    }

    // Función para buscar un Wireframe por ID
    fun fetchWireframeById(id: Long) {
        viewModelScope.launch(Dispatchers.Default) {
            // Aquí solo estamos actualizando el estado de onewireframe
            onewireframe.value = WireframeApi().listWireframe().find { it.id == id }
        }
    }
}
