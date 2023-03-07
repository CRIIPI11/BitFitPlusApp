package com.example.bitfit

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM food_table")
    fun getAll(): Flow<List<FoodEntity>>

    @Insert
    fun insert(Food: FoodEntity)

    @Query("SELECT SUM(calories) FROM food_table")
    fun getAvg(): Int

    @Query("SELECT MIN(calories) FROM food_table")
    fun getMin(): Int

    @Query("SELECT MAX(calories) FROM food_table")
    fun getMax(): Int
}
