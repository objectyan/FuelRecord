package me.objectyan.fuelrecord.db.table

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

object VehiclesTable {
    var TableName = "Vehicles"
    var ID = "ID"
    var Image = "Image"
    var Name = "Name"
    var Description = "Description"
    var DistanceUnit = "DistanceUnit"
    var FuelUnit = "FuelUnit"
    var Comsumption = "Comsumption"
    var GASType = "GASType"
    var GASTypeOther = "GASTypeOther"
    var Make = "Make"
    var Model = "Model"
    var Year = "Year"
    var LicensePlate = "LicensePlate"
    var VIN = "VIN"
    var InsurancePolicy = "InsurancePolicy"
    var IsActive = "IsActive"

    fun createTable(db: SQLiteDatabase) {
        db.createTable(
                this.TableName,
                true,
                this.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                this.Name to TEXT,
                this.Image to TEXT,
                this.Description to TEXT,
                this.DistanceUnit to TEXT,
                this.FuelUnit to TEXT,
                this.Comsumption to TEXT,
                this.GASType to TEXT,
                this.GASTypeOther to TEXT,
                this.Make to TEXT,
                this.Model to TEXT,
                this.Year to TEXT,
                this.LicensePlate to TEXT,
                this.VIN to TEXT,
                this.InsurancePolicy to TEXT,
                this.IsActive to INTEGER + DEFAULT("1") + NOT_NULL
        );
    }
    fun dropTable(db: SQLiteDatabase) {
        db.dropTable(this.TableName,true);
    }
}

data class Vehicles(val map: MutableMap<String, Any?>) {
    var ID: Long by map
    var Name: String by map
    var Image: String by map
    var Description: String by map
    var DistanceUnit: String by map
    var FuelUnit: String by map
    var Comsumption: String by map
    var GASType: String by map
    var GASTypeOther: String by map
    var Make: String by map
    var Model: String by map
    var Year: String by map
    var LicensePlate: String by map
    var VIN: String by map
    var InsurancePolicy: String by map
    var IsActive: Boolean by map

    constructor() : this(HashMap()) {
    }

    constructor(ID:Long,Name: String,Image: String,Description: String,DistanceUnit: String,
                FuelUnit: String,Comsumption: String,GASType: String,GASTypeOther: String,
                Make: String,Model: String,Year: String,LicensePlate: String,
                VIN: String,InsurancePolicy: String,IsActive: Boolean) : this(HashMap()) {
        this.ID = ID;
        this.Name = Name;
        this.Image = Image;
        this.Description = Description;
        this.DistanceUnit = DistanceUnit;
        this.FuelUnit = FuelUnit;
        this.Comsumption = Comsumption;
        this.GASType = GASType;
        this.GASTypeOther = GASTypeOther;
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.LicensePlate = LicensePlate;
        this.VIN = VIN;
        this.InsurancePolicy = InsurancePolicy;
        this.IsActive = IsActive;
    }
}