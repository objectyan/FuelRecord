package me.objectyan.fuelrecord.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import me.objectyan.fuelrecord.db.table.*
import org.jetbrains.anko.db.*
import me.objectyan.fuelrecord.R

class DatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "FuelRecord"
        val DB_VERSION = 1
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
        CostTable.createTable(db)
        ReminderTable.createTable(db)
        Log.i("SQLiteDatabase","create db")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        VehiclesTable.dropTable(db)
        AttachmentTable.dropTable(db)
        CostTable.dropTable(db)
        ReminderTable.dropTable(db)
        onCreate(db)
        Log.i("SQLiteDatabase","upgrade db")
    }
}

val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstance(getApplicationContext())

