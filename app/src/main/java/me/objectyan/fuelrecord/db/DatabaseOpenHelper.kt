package me.objectyan.fuelrecord.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import me.objectyan.fuelrecord.db.table.*
import org.jetbrains.anko.db.*
import me.objectyan.fuelrecord.R

class DatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = R.string.app_name as String
        val DB_VERSION = R.string.db_version as Int
        private var instance: DatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseOpenHelper {
            if (instance == null) {
                instance = DatabaseOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        VehiclesTable.createTable(db)
        AttachmentTable.createTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        VehiclesTable.dropTable(db)
        AttachmentTable.dropTable(db)
        onCreate(db)
    }
}