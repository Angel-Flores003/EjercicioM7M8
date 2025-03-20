package cat.itb.m78.exercices.DateBase

import app.cash.sqldelight.db.SqlDriver
import cat.itb.m78.exercices.db.Database

expect fun Db(): SqlDriver
fun createDatabase(): Database {
    val driver = Db()
    return Database(driver)
}
val database by lazy { createDatabase() }