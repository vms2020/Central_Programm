package com.one.two.centralprogramm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.one.two.centralprogramm.ui.theme.CentralProgrammTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CentralProgrammTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScr()
                }
            }
        }
    }
}

@Composable
fun MainScr(modifier: Modifier = Modifier) {
    Column (modifier = modifier){
        Text(text = "Hello!")
        Button(onClick = { /*TODO*/ }) {
            Text("FETCH")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CentralProgrammTheme {
        MainScr()
    }
}