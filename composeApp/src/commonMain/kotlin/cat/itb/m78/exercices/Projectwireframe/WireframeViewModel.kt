package cat.itb.m78.exercices.Projectwireframe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WireframeViewModel : ViewModel() {
    val wireframe = mutableStateOf<List<Wireframe>?>(null)
    val onewireframe = mutableStateOf<Wireframe?>(null)
    val otherlist = mutableStateOf<List<Wireframe>?>(null)
    var otherlistfilter = mutableStateOf("")

    init {
        viewModelScope.launch(Dispatchers.Default) {
            wireframe.value = WireframeApi().listWireframe()
            otherlist.value = WireframeApi().listWireframe()
        }
    }

    // Buscar un Wireframe por ID
    fun fetchWireframeById(id: Long) {
        viewModelScope.launch(Dispatchers.Default) {
            // Actualizar el estado de onewireframe
            onewireframe.value = WireframeApi().listWireframe().find { it.id == id }
        }
    }

    fun filterList(newFilter: String) {
        otherlistfilter.value = newFilter
        otherlist.value = wireframe.value?.filter { it.name.contains(newFilter) }
    }
}