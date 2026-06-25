package kr.hnu.ice.firstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kr.hnu.ice.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        Text(
            text = "Hello $name!",
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            android.widget.Toast.makeText(context, "오늘 날짜: $today", android.widget.Toast.LENGTH_LONG).show()
        }) {
            Text(text = "오늘 날짜 보기")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstApplicationTheme {
        Greeting("Android")
    }
}