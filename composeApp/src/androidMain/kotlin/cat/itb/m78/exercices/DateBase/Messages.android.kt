//package cat.itb.m78.exercices.DateBase
//
//import app.cash.sqldelight.db.SqlDriver
//import app.cash.sqldelight.driver.android.AndroidSqliteDriver
//import cat.itb.m78.exercices.db.Database
//
//actual fun Messages(): SqlDriver {
//    val appContext = applicationContext
//    return AndroidSqliteDriver(Database.Schema, appContext, "DatabaseMessages.db")
//}