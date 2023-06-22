package com.rajeshvijayakumr.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ListViewActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val items = listOf("Item 1", "Item 2", "Item 3","Item 4", "Item 5", "Item 6","Item 7", "Item 8", "Item 9")

            setContent {
                MyScreen(items)
            }
        }
    }

    @Composable
    fun MyScreen(items: List<String>) {
        LazyColumn {
            items(items) { item ->
                ListItem(item = item)
            }
        }
    }

    @Composable
    fun ListItem(item: String) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = item)
            // Add other custom content for each item
        }
    }
