package com.example.todolistapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolistapp.viewmodel.ToDoViewModel



@Composable
fun ToDoScreen(toDoViewModel: ToDoViewModel = viewModel()) {
    var newTask by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = newTask,
                onValueChange = { newTask = it },
                label = { Text("Enter Task") },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            Button(
                onClick = {
                    if (newTask.isNotBlank()) {
                        toDoViewModel.addTask(newTask)
                        newTask = ""  // Clear input field after adding task
                    }
                }
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(toDoViewModel.toDoList) { task ->
                ToDoItemView(task, toDoViewModel::toggleTask, toDoViewModel::removeTask)
            }
        }
    }
}
