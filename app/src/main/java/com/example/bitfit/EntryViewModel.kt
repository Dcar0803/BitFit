package com.example.bitfit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EntryViewModel(private val repository: EntryRepository) : ViewModel() {
    val allEntries: LiveData<List<Entry>> = repository.allEntries
    val allNutritionEntries: LiveData<List<NutritionEntry>> = repository.allNutritionEntries
    val allWaterEntries: LiveData<List<WaterEntry>> = repository.allWaterEntries

    fun insertNutritionEntry(entry: NutritionEntry) = viewModelScope.launch {
        repository.insertNutritionEntry(entry)
    }

    fun insertWaterEntry(entry: WaterEntry) = viewModelScope.launch {
        repository.insertWaterEntry(entry)
    }
}
