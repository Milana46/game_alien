package com.example.newsapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//  типичный data class только со специальными аннотациями!!!
@Entity (tableName = "items")
data class ItemEntity (

    @PrimaryKey(autoGenerate = true)
        var id:Int?=null,
     @ColumnInfo(name="name")
        var name:String,
    @ColumnInfo(name="price")
    var price:String



)

