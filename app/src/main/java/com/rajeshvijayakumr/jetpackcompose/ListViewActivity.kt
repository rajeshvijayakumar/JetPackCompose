package com.rajeshvijayakumr.jetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils

class ListViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = listOf(
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5", "Item 6"
        )

        setContent {
            MyScreen(items = items)
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
    val context = LocalContext.current
    // Use Clickable modifier to handle item click
    Column(
        modifier = Modifier
            .clickable { showToast(context, item) }
            .fillMaxWidth()
            .fillMaxWidth()
            .padding(6.dp)
            .background(
                colorResource(id = android.R.color.holo_blue_dark),
                shape = RectangleShape
            ),
        verticalArrangement = Arrangement.Center,
    ) {

            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp)
                    .height(60.dp)
                    .wrapContentSize(align = Alignment.CenterStart),
                color = Color.White,
                textAlign = TextAlign.Start

            )
    }
}

fun showToast(context: Context, item: String) {
    Toast.makeText(
        context,
        "Clicked: $item",
        Toast.LENGTH_SHORT
    ).show()
}