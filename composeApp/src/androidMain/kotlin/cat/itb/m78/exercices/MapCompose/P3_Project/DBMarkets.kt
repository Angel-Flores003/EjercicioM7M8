package cat.itb.m78.exercices.MapCompose.P3_Project

import android.provider.BaseColumns
import app.cash.sqldelight.db.SqlDriver
import cat.itb.m78.exercices.db.Database

expect fun createMyDB(): SqlDriver
fun createDatabase(): Database {
    val driver = createMyDB()
    return Database(driver)
}

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "entry"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_SUBTITLE = "subtitle"
    }
}