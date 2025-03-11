package cat.itb.m78.exercices.Api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class BcnTree(
    @SerialName("cat_nom_cientific") val scientificName : String,
    @SerialName("cat_nom_catala") val name: String?,
    @SerialName("adreca") val adress: String
)

fun mainSuspend() = runBlocking {
    // Aquí ejecutas tu función suspendida
    main()
}

suspend fun main(){
    val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    val trees : List<BcnTree> = client.get("https://opendata-ajuntament.barcelona.cat/resources/bcn/Arbrat/OD_Arbrat_Zona_BCN.json").body()
    println("There are ${trees.size} in Barcelona")
    println("Example: \n Nom: ${trees.first().name} \n Nom cientific: ${trees.first().scientificName} \n Adreca: ${trees.first().adress}")
}