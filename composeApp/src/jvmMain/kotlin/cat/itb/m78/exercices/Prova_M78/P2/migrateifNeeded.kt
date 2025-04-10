package cat.itb.m78.exercices.Prova_M78.P2

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

fun migrateifNeeded(Prova2: JdbcSqliteDriver, schema: SqlSchema<QueryResult.Value<Unit>>) {
    val currentVer = readVersion(Prova2)
    val schemaVer = schema.version
    if (currentVer == 0L) {
        schema.create(Prova2)
        updateVersion(Prova2, schemaVer)
    } else {
        if (schemaVer > currentVer) {
            schema.migrate(Prova2, currentVer, schemaVer)
            updateVersion(Prova2, schemaVer)
        } else if(currentVer > schemaVer){
            throw UnsupportedOperationException("Database can't downgrade from $currentVer to $schemaVer")
        }
    }
}

private fun readVersion(prova2: JdbcSqliteDriver): Long {
    val mapper = { cursor: SqlCursor ->
        QueryResult.Value(if (cursor.next().value) cursor.getLong(0) else null)
    }
    return prova2.executeQuery(null, "PRAGMA user_version", mapper, 0, null).value ?: 0L
}

private fun updateVersion(prova2: JdbcSqliteDriver, version: Long) {
    prova2.execute(null, "PRAGMA user_version = $version", 0, null)
}