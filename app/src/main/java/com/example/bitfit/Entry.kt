package com.example.bitfit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entries")
data class Entry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String, // Define the date field
    val details: String // Define the details field
)
