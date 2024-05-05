package com.example.newsapp


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
sealed interface Dao {

    @Insert
    fun insertItem(item:ItemEntity)

    //считывание + выдаст список со всеми элементами!!!
    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<ItemEntity>>
}