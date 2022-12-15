package com.tutorial.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            Card(false,"Task1"),
            Card(false,"Task2"),
            Card(false,"Task3"),
            Card(false,"Task4"),
            Card(false,"Task5"),
        )

        val recycler = findViewById<RecyclerView>(R.id.recyclerView);
        val adapter = TodoAdapter(todoList)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this);

        findViewById<Button>(R.id.addTask).setOnClickListener{
            val title = findViewById<EditText>(R.id.editText)
            val todo = Card(false,title.text.toString())
            title.setText("")
            title.clearFocus()
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size -1)
        }
    }
}