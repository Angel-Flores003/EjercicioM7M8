package cat.itb.m78.exercices.Api

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_2
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@Serializable
data class Jokes(
    @SerialName("id") val ID: Int,
    @SerialName("setup") val setup: String,
    @SerialName("punchline") val punchline: String
)

suspend fun fetchRandomJoke(): Jokes {
    val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    val jokes: List<Jokes> = client.get("https://api.sampleapis.com/jokes/goodJokes").body()
    val randomIndex = Random.nextInt(jokes.size)
    return jokes[randomIndex]
}

@Composable
fun ChisteRandom() {
    val (joke, setJoke) = remember { mutableStateOf<Jokes?>(null) }
    LaunchedEffect(Unit) {
        val randomJoke = fetchRandomJoke()
        setJoke(randomJoke)
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        if (joke != null) {
            Text("Setup: ${joke.setup}")
            Text("Punchline: ${joke.punchline}")
        } else {
            Text("Cargando chiste...")
            Image(
                painter = painterResource(Res.drawable.dice_2),
                modifier = Modifier.size((100.dp)),
                contentDescription = null
            )
        }
    }
}

@Composable
fun DefaultPreview() {
    ChisteRandom()
}