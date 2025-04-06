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
    val showFavorites = mutableStateOf(false)

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

//    fun filterList(newFilter: String) {
//        otherlistfilter.value = newFilter
//        otherlist.value = wireframe.value?.filter { it.name.contains(newFilter) }
//    }

    fun filterList(newFilter: String) {
        otherlistfilter.value = newFilter
        applyFilters()
    }

    fun toggleFavorites(showFavs: Boolean) {
        showFavorites.value = showFavs
        applyFilters()
    }

    fun applyFilters() {
        val baseList = wireframe.value ?: emptyList()
        val filterText = otherlistfilter.value.lowercase()
        val filteredList = baseList.filter { wireframe ->
            val matchesText = wireframe.name.lowercase().contains(filterText)
            val matchesFavorite = !showFavorites.value || wireframe.isFavorite == true
            matchesText && matchesFavorite
        }
        otherlist.value = filteredList
    }

}