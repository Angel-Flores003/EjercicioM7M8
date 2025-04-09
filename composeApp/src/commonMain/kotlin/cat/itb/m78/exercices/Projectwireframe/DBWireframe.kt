//package cat.itb.m78.exercices.Projectwireframe
//
//import app.cash.sqldelight.db.SqlDriver
//import cat.itb.m78.exercices.db.Database
//
//expect fun WireframeDB(): SqlDriver
//fun createDatabase(): Database {
//    val name = WireframeDB()
//    return Database(name)
//}
//val database by lazy { createDatabase() }