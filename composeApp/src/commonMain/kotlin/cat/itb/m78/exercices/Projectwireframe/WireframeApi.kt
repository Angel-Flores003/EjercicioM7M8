package cat.itb.m78.exercices.Projectwireframe

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
data class Wireframe(
    val id: Long,
    val name: String,
    val size: String,
    val age: String? = null,
    val bounty: String? = null,
    val crew: crew,
    val fruit: fruit? = null,
    @SerialName ("job") val funcion: String,
    val status: String,
)

@Serializable
data class crew(
    val id: Long,
    val name: String,
    val description: String? = null,
    val status: String,
    @SerialName("number") val tripulantes: String,
    @SerialName ("total_prime") val total_price: String,
)

@Serializable
data class fruit(
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    @SerialName("filename") val Imatge: String,
    val roman_name: String,
)

class WireframeApi {
    private val url = "https://api.api-onepiece.com/v2/characters/en"
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listWireframe() = client.get(url).body<List<Wireframe>>()
}