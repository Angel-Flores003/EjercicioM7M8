package cat.itb.m78.exercices.Prova_M78.P2

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.DateBase.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Prova2ViewModel : ViewModel(){
    val prova2 = mutableStateOf<List<Prova2>?>(null)
    val oneprova2 = mutableStateOf<Prova2?>(null)
    val otherlist = mutableStateOf<List<Prova2>?>(null)
    var otherlistfilter = mutableStateOf("")
    val onShowAll = mutableStateOf(false)
    val messagetext = mutableStateListOf<String>()

    val myStudentsQueries = database.myTableQueries
    val allStudents = myStudentsQueries.selectAll().executeAsList()
    val insert = myStudentsQueries.insert("")

    init {
        viewModelScope.launch(Dispatchers.Default) {
            prova2.value = Prova2Api().listStudents()
            otherlist.value = Prova2Api().listStudents()
        }
    }

    fun fetchProva2ById(id: Long) {
        val prova2 = prova2.value ?: return


        viewModelScope.launch(Dispatchers.Default) {
            oneprova2.value = Prova2Api().listStudents().find { it.id == id }
        }
    }

    fun toggleAll(showAll: Boolean) {
        onShowAll.value = showAll
        applyFilters()
    }

    fun applyFilters() {
        val baseList = prova2.value ?: emptyList()
        val filterText = otherlistfilter.value.lowercase()
        val filteredList = baseList.filter { prova2 ->
            val matchesText = prova2.name.lowercase().contains(filterText)
            val matchesFavorite = !onShowAll.value || prova2.haveFalta == true
            matchesText && matchesFavorite
        }
        otherlist.value = filteredList
    }
}