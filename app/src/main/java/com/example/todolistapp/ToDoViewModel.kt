package com.example.todolistapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.todolistapp.model.ToDoItem

class ToDoViewModel : ViewModel() {
    private var nextId = 0
    var toDoList = mutableStateListOf<ToDoItem>()
        private set

    fun addTask(task: String) {
        if (task.isNotBlank()) {
            toDoList.add(ToDoItem(nextId++, task))
        }
    }

    fun removeTask(id: Int) {
        toDoList.removeAll { it.id == id }
    }

    fun toggleTask(id: Int) {
        toDoList.replaceAll {
            if (it.id == id) it.copy(isDone = !it.isDone) else it
        }
    }
}
