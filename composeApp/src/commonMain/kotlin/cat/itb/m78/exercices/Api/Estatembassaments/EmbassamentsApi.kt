package cat.itb.m78.exercices.Api.Estatembassaments

import cat.itb.m78.exercices.Api.CountryMateu.CountriesApi
import cat.itb.m78.exercices.Api.CountryMateu.Country
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Embassaments(
    val dia: DateTimeUnit,
    val estaci: String,
    val nivell_absolut: Int,
    val percentatge_volum_embassat: Int,
    val volum_embassat: Double,
)

object EmbassamentsApi {
    private val url = "https://analisi.transparenciacatalunya.cat/resource/gn9e-3qhr.json"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listEmbassaments() = client.get(url).body<List<Embassaments>>()
}
//
//@Serializable
//data class Embassaments(
//    @Serializable(with = DateTimeSerializer::class) val dia: LocalDateTime,
//    val estaci: String,
//    val nivell_absolut: Int,
//    val percentatge_volum_embassat: Int,
//    val volum_embassat: Double,
//)