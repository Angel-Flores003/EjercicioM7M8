package cat.itb.m78.exercices.Prova_M78.P2

import cat.itb.m78.exercices.Projectwireframe.Wireframe
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Prova2(
    val id: Long,
    val name: String,
    val surnames: String,
    val email: String,
    @SerialName("photo_link") val photo: String,

    val haveFalta: Boolean = false,
    val countfaltes: Int = 0,
)

class Prova2Api {
    private val url = "https://fp.mateuyabar.com/DAM-M78/composeP2/exam/students.json"
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listStudents() = client.get(url).body<List<Prova2>>()

}