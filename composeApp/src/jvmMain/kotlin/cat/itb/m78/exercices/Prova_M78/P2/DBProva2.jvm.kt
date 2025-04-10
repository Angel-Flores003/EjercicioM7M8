//package cat.itb.m78.exercices.Prova_M78.P2
//
//import app.cash.sqldelight.db.SqlDriver
//import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
//import cat.itb.m78.exercices.DateBase.migrateIfNeeded
//import cat.itb.m78.exercices.db.Database
//import kotlin.io.path.Path
//import kotlin.io.path.absolutePathString
//
//actual fun DBProva2(): SqlDriver {
//    val userHome = System.getProperty("user.home")
//    val file = Path(userHome, "myDatabase.db")
//    val studentId = JdbcSqliteDriver("jdbc:sqlite:${file.absolutePathString()}")
//    migrateifNeeded(studentId, Database.Schema)
//    return studentId
//}
//
////val now = Clock.System.now()      Para la hora actual