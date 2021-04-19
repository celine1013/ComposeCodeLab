package com.example.composecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
        Surface(color = BlueGray900) {
            content()
        }
    }
}

@Composable
fun MainScreenContent(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }
    Column {
        for(name in names) {
            Greeting(name = name)
            Divider(color = Pink50)
        }
        Divider(modifier = Modifier.padding(32.dp))
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", color = Pink50, modifier = Modifier.padding(24.dp))
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = {updateCount(count+1) }) {
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
