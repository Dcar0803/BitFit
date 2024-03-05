// MainActivity.kt
package com.example.bitfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var entryViewModel: EntryViewModel
    private lateinit var entryAdapter: EntryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewEntries: RecyclerView = findViewById(R.id.recyclerViewEntries)
        entryAdapter = EntryAdapter(emptyList())
        recyclerViewEntries.adapter = entryAdapter
        recyclerViewEntries.layoutManager = LinearLayoutManager(this)

        // Pass applicationContext to the EntryViewModel constructor
        entryViewModel = ViewModelProvider(this, EntryViewModelFactory(applicationContext)).get(EntryViewModel::class.java)
        entryViewModel.allEntries.observe(this, Observer<List<Entry>> { entries ->
            entries?.let { entryAdapter.updateEntries(it) }
        })

        val buttonCreateEntry: Button = findViewById(R.id.buttonCreateEntry)
        buttonCreateEntry.setOnClickListener {
            // Open AddEntryActivity when the button is clicked
            val intent = Intent(this, AddEntryActivity::class.java)
            startActivity(intent)
        }
    }
}