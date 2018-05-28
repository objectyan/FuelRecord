package me.objectyan.fuelrecord.db.table

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import java.util.*

object ReminderTable {
    var TableName = "Reminder"
    var ID = "ID"
    var Title = "Title"
    var Date = "Date"
    var CostType = "CostType"
    var Description = "Description"
    var Mileage = "Mileage"
    var Distance = "Distance"
    var Month = "Month"
    var IsFinsh = "IsFinsh"

    fun createTable(db: SQLiteDatabase) {
        db.createTable(
                this.TableName,
                true,
                this.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                this.Title to TEXT,
                this.Description to TEXT,
                this.Date to REAL,
                this.CostType to TEXT,
                this.Mileage to INTEGER,
                this.Distance to INTEGER,
                this.Month to INTEGER,
                this.IsFinsh to INTEGER + DEFAULT("0") + NOT_NULL
        );
    }
    fun dropTable(db: SQLiteDatabase) {
        db.dropTable(this.TableName,true);
    }
}

data class Reminder(val map: MutableMap<String, Any?>) {
    var ID: Long by map
    var Title: String by map
    var Date: Date by map
    var CostType: String by map
    var Description: String by map
    var Mileage: Int by map
    var Distance: Int by map
    var Month: Double by map
    var IsFinsh: Boolean by map

    constructor() : this(HashMap()) {
    }

    constructor(ID:Long,Title: String,Date: Date,CostType: String,
                Description: String,Mileage: Int,Distance: Int,Month: Double,IsFinsh: Boolean) : this(HashMap()) {
        this.ID = ID;
        this.Title = Title;
        this.Date = Date;
        this.CostType = CostType;
        this.Description = Description;
        this.Mileage = Mileage;
        this.Distance = Distance;
        this.Month = Month;
        this.IsFinsh = IsFinsh;
    }
}