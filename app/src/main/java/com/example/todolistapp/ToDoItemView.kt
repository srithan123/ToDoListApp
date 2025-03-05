package com.example.todolistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.todolistapp.model.ToDoItem

@Composable
fun ToDoItemView(item: ToDoItem, onToggle: (Int) -> Unit, onRemove: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onToggle(item.id) }
    ) {
        Checkbox(
            checked = item.isDone,
            onCheckedChange = { onToggle(item.id) }
        )
        Text(
            text = item.task,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            style = if (item.isDone) {
                MaterialTheme.typography.body1.copy(textDecoration = TextDecoration.LineThrough)
            } else {
                MaterialTheme.typography.body1
            }
        )
        IconButton(onClick = { onRemove(item.id) }) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete Task")
        }
    }
}
