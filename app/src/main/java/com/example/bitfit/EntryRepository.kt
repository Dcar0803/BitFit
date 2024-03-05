// EntryRepository.kt
package com.example.bitfit

import androidx.lifecycle.LiveData

class EntryRepository(private val entryDao: EntryDao) {
    val allEntries: LiveData<List<Entry>> = entryDao.getAllEntries()
    val allNutritionEntries: LiveData<List<NutritionEntry>> = entryDao.getAllNutritionEntries()
    val allWaterEntries: LiveData<List<WaterEntry>> = entryDao.getAllWaterEntries()

    suspend fun insertNutritionEntry(entry: Entry) {
        entryDao.insertNutritionEntry(entry)
    }

    suspend fun insertWaterEntry(entry: WaterEntry) {
        entryDao.insertWaterEntry(entry)
    }
}