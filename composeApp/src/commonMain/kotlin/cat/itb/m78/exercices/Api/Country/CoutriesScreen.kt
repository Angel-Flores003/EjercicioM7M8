package cat.itb.m78.exercices.Api.Country

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.Api.CountryMateu.Country
import coil3.compose.AsyncImage

@Composable
fun countriescreen() {
    val viewModel = viewModel { countriesViewModel() }
    val countries = viewModel.countries.value
 //   countriesscreen(countries)
}

@Composable
fun countriesscreen(countries: List<Country>?) {
    if (countries == null) {
        CircularProgressIndicator()
    } else {
        LazyColumn() {
            items(countries) { country ->
                Column (modifier = Modifier.fillMaxSize()){
                    Row {
                        Text(country.name, fontWeight = FontWeight.Bold)
                        AsyncImage(
                            modifier = Modifier.size(50.dp),
                            model = country.media.flag,
                            contentDescription = "flag",
                        )
                    }
                    Text(country.capital)
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}