package cat.itb.m78.exercices.DateBase

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf

class MessagesViewModel {
    val messages = mutableStateListOf<String>()
    val buttonText = mutableStateListOf<String>()

    fun aleatorio(){
        database.myTableQueries.insert("dsadas")
        val list = database.myTableQueries.selectAll().executeAsList()
        println(list)
    }
}