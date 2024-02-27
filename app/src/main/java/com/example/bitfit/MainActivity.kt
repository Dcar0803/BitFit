package com.example.bitfit

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

        entryViewModel = ViewModelProvider(this).get(EntryViewModel::class.java)
        entryViewModel.allEntries.observe(this, Observer<List<Entry>> { entries ->
            entries?.let { entryAdapter.updateEntries(it) }
        })

        val buttonCreateEntry: Button = findViewById(R.id.buttonCreateEntry)
        buttonCreateEntry.setOnClickListener {
            // Handle button click to create new entry
            // You can navigate to another activity/fragment for creating entry
        }
    }
}
