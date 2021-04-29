package com.example.composecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecodelab.ui.theme.BlueGray900
import com.example.composecodelab.ui.theme.ComposeCodeLabTheme
import com.example.composecodelab.ui.theme.Pink50

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent {
                MainScreenContent()
            }
        }
    }
}

@Composable
fun AppContent(content: @Composable () -> Unit) {
    ComposeCodeLabTheme { //Depends on the porject name
        Surface(color = BlueGray900, modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
fun MainScreenContent(names: List<String> = List(1000) { "Item #$it" }) {
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names, Modifier.weight(1f))
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name = name)
            Divider(color = Pink50)
        }
    }
}

@Composable
fun Greeting(name: String) {
    val isSelected = remember { mutableStateOf(false) }
    val backgroundColor =
        animateColorAsState(if (isSelected.value) Color.Red else Color.Transparent)

    Text(text = "Hello $name!",
        color = Pink50,
        modifier = Modifier
            .padding(24.dp)
            .background(color = backgroundColor.value)
            .clickable(onClick = { isSelected.value = !isSelected.value })
    )
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text("I've been clicked $count times")
    }
}

@Preview("Main Screen Preview")
@Composable
fun DefaultPreview() {
    AppContent {
        MainScreenContent()
    }
}
