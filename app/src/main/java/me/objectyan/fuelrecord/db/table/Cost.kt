package me.objectyan.fuelrecord.db.table

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import java.util.*

object CostTable {
    var TableName = "Cost"
    var ID = "ID"
    var Title = "Title"
    var Cost = "Cost"
    var Date = "Date"
    var IsIncome = "IsIncome"
    var CostType = "CostType"
    var Description = "Description"

    fun createTable(db: SQLiteDatabase) {
        db.createTable(
                this.TableName,
                true,
                this.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                this.Title to TEXT,
                this.Cost to INTEGER,
                this.Description to TEXT,
                this.Date to REAL,
                this.IsIncome to INTEGER + DEFAULT("0") + NOT_NULL,
                this.CostType to TEXT
        );
    }
    fun dropTable(db: SQLiteDatabase) {
        db.dropTable(this.TableName,true);
    }
}

data class Cost(val map: MutableMap<String, Any?>) {
    var ID: Long by map
    var Title: String by map
    var Cost: Double by map
    var Date: Date by map
    var IsIncome: Boolean by map
    var CostType: String by map
    var Description: String by map

    constructor() : this(HashMap()) {
    }

    constructor(ID:Long,Title: String,Cost: Double,Date: Date,IsIncome: Boolean,
                CostType: String,Description: String) : this(HashMap()) {
        this.ID = ID;
        this.Title = Title;
        this.Cost = Cost;
        this.Date = Date;
        this.IsIncome = IsIncome;
        this.CostType = CostType;
        this.Description = Description;
    }
}