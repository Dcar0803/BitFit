// EntryDao.kt
package com.example.bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EntryDao {
    @Insert
    suspend fun insertNutritionEntry(entry: com.example.bitfit.Entry)

    @Insert
    suspend fun insertWaterEntry(entry: WaterEntry)

    @Query("SELECT * FROM nutrition_entries ORDER BY date DESC")
    fun getAllNutritionEntries(): LiveData<List<NutritionEntry>>

    @Query("SELECT * FROM water_entries ORDER BY date DESC")
    fun getAllWaterEntries(): LiveData<List<WaterEntry>>

    @Query("SELECT id, date, details FROM nutrition_entries UNION SELECT id, date, details FROM water_entries ORDER BY date DESC")
    fun getAllEntries(): LiveData<List<Entry>>
}