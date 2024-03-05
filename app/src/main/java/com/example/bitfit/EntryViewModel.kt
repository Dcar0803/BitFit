// EntryViewModel.kt
package com.example.bitfit

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EntryViewModel(private val context: Context, private val repository: EntryRepository) : ViewModel() {
    val allEntries: LiveData<List<Entry>> = repository.allEntries
    val allNutritionEntries: LiveData<List<NutritionEntry>> = repository.allNutritionEntries
    val allWaterEntries: LiveData<List<WaterEntry>> = repository.allWaterEntries

    // Use applicationContext when needed
    fun insertNutritionEntry(entry: Entry) = viewModelScope.launch {
        repository.insertNutritionEntry(entry)
    }

    fun insertWaterEntry(entry: WaterEntry) = viewModelScope.launch {
        repository.insertWaterEntry(entry)
    }
}