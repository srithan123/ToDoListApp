package com.example.todolistapp.model

data class ToDoItem(
    val id: Int,
    val task: String,
    val isDone: Boolean = false
)
