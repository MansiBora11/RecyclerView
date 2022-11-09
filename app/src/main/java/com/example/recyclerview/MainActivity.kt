package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity :
    AppCompatActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(
            savedInstanceState
        )
        setContentView(
            R.layout.activity_main
        )

        val btnAddTodo =
            findViewById<Button>(
                R.id.btnAddTodo
            )
        var todoList =
            mutableListOf(
                Todo(
                    "Learning about rv",
                    true
                ),
                Todo(
                    "Feed my dog",
                    true
                ),
                Todo(
                    "Eat some food",
                    false
                ),
                Todo(
                    "Play a game",
                    false
                ),
                Todo(
                    "Take a shower",
                    false
                ),
                Todo(
                    "Read a book",
                    false
                )
            )

        val adapter =
            TodoAdapter(
                todoList
            )
        val rvTodos =
            findViewById<RecyclerView>(
                R.id.rvTodo
            )
        rvTodos.adapter =
            adapter
        rvTodos.layoutManager =
            LinearLayoutManager(
                this
            )

        btnAddTodo.setOnClickListener {
            val etTodo =
                findViewById<EditText>(
                    R.id.etTodo
                )
            val title =
                etTodo.text.toString()
            val todo =
                Todo(
                    title,
                    false
                )
            todoList.add(
                todo
            )
            adapter.notifyItemInserted(
                todoList.size - 1
            )

        }


    }
}