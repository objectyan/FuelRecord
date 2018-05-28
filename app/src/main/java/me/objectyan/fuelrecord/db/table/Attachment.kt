package me.objectyan.fuelrecord.db.table

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

object AttachmentTable {
    var TableName = "Attachment"
    var ID = "ID"
    var Source = "Source"
    var Type = "Type"
    var IsActive = "IsActive"

    fun createTable(db: SQLiteDatabase) {
        db.createTable(
                this.TableName,
                true,
                this.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                this.Source to TEXT,
                this.Type to TEXT,
                this.IsActive to INTEGER + DEFAULT("0") + NOT_NULL
        );
    }
    fun dropTable(db: SQLiteDatabase) {
        db.dropTable(this.TableName,true);
    }
}

data class Attachment(val map: MutableMap<String, Any?>) {
    var ID: Long by map
    var Source: String by map
    var Type: String by map
    var IsActive: Boolean by map

    constructor() : this(HashMap()) {
    }

    constructor(ID:Long,Source: String,Type: String,IsActive: Boolean) : this(HashMap()) {
        this.ID = ID;
        this.Source = Source;
        this.Type = Type;
        this.IsActive = IsActive;
    }
}