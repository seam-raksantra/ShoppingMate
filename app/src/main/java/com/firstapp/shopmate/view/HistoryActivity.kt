package com.firstapp.shopmate.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.shopmate.R
import java.util.Locale
import java.util.stream.Collectors


class HistoryActivity : AppCompatActivity() {
    private var historyList: List<String> = ArrayList()
    private var adapter: ArrayAdapter<String>? = null
    private val filteredList: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val backButton = findViewById<ImageView>(R.id.backButton)
        val searchHistory = findViewById<EditText>(R.id.searchHistory)
        val historyListView = findViewById<ListView>(R.id.historyListView)

        // Load data
        val prefs = getSharedPreferences("UserNotes", MODE_PRIVATE)
        historyList = ArrayList(prefs.getStringSet("notesHistory", HashSet()))

        filteredList.addAll(historyList)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, filteredList)
        historyListView.adapter = adapter

        // Back button function
        backButton.setOnClickListener { v: View? ->
            val intent = Intent(
                this@HistoryActivity,
                CategoryActivity::class.java
            )
            startActivity(intent)
            finish()
        }

        // Search filter
        searchHistory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val query = s.toString().lowercase(Locale.getDefault())
                filteredList.clear()
                filteredList.addAll(historyList.stream()
                    .filter { note: String ->
                        note.lowercase(Locale.getDefault()).contains(query)
                    }
                    .collect(Collectors.toList()))
                adapter!!.notifyDataSetChanged()
            }
        })
    }
}
