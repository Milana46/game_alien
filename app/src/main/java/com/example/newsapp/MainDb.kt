package com.example.newsapp

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version=1,
    entities = [ItemEntity::class]

)
//класс представляет абстракцию БД;
abstract class MainDb() :RoomDatabase() {

  //абстрактная функция НЕ имеет реализации!!!
    abstract fun getDao():Dao


    companion object {
        //создание Бд или передача ее, если она уже есть
        fun getDb(context: Context): MainDb {
            return Room.databaseBuilder(context.applicationContext, MainDb::class.java, "test.db").build()
        }
    }




}