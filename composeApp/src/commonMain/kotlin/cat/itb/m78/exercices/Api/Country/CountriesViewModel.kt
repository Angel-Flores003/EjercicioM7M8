package cat.itb.m78.exercices.Api.Country

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class countriesViewModel: ViewModel() {
    val countries = mutableStateOf<List<Countries>?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default){
            countries.value = CountrieApi.listCountries()
        }
    }
}