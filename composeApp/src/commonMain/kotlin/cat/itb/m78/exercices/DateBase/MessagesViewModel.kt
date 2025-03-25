package cat.itb.m78.exercices.DateBase

class MessagesViewModel {
    fun aleatorio(){
        database.myTableQueries.insert("dsadas")

        val list = database.myTableQueries.selectAll().executeAsList()

        println(list)

    }
}