package cat.itb.m78.exercices.DateBase

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import cat.itb.m78.exercices.State.Message

class MessagesViewModel {
    val messages = mutableStateOf<List<Message>?>(null)
    val messagetext = mutableStateListOf<String>()

    fun SellectAll(){
        database.myTableQueries.insert("dsadas")
        val list = database.myTableQueries.selectAll().executeAsList()
        println(list)
    }
}