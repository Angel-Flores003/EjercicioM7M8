package cat.itb.m78.exercices.Api.Country

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cat.itb.m78.exercices.Api.CountryMateu.Country
import coil3.Image
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Countries(
   val name: String,
   val capital: String,
   val media: CountriesMedia,
)

@Serializable
data class CountriesMedia(
    val flag: String,
)

object CountrieApi{
    private val url = "https://api.sampleapis.com/countries/countries"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listCountries() = client.get(url).body<List<Country>>()
}