package cat.itb.m78.exercices.DateBase

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import cat.itb.m78.exercices.db.Database
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

actual fun Db(): SqlDriver {
    val userHome = System.getProperty("user.home")
    val file = Path(userHome, "myDatabase.db")
    val driver = JdbcSqliteDriver("jdbc:sqlite:${file.absolutePathString()}")
    migrateIfNeeded(driver, Database.Schema)
    return driver
}