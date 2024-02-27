// WaterEntry.kt
package com.example.bitfit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "water_entries")
data class WaterEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String, // Define the date field
    val details: String // Add other fields specific to water entry
)
