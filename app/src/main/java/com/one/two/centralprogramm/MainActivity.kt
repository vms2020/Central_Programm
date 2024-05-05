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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.one.two.centralprogramm.ui.theme.CentralProgrammTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.example.FetchResponse
import org.example.SubmoduleCommitHash

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

    val scope = rememberCoroutineScope()

    var commitHash by rememberSaveable {
        mutableStateOf("hhhhhhhhaaaaaaassssssshhhhhh")
    }

    var commitTime by rememberSaveable {
        mutableStateOf("commit ttttiiimmmmeeee")
    }

    var fetchTime by rememberSaveable {
        mutableStateOf("fetch ttiimmee")
    }
    Column(modifier = modifier) {
        Text(text = "Hello!")
        Text(text = commitHash)
        Text(text = commitTime)
        Text(text = fetchTime)

        Button(onClick = {
            scope.launch(Dispatchers.IO) {
                var r = org.example.Library.fetchHash(
                    "https://seva.vsevolod.dynv6.net",
                    "fetchme/zxcv.php",
                    mapOf(),
                    false,
                )
                if ((r is FetchResponse.Success<*>) &&
                        (r.resp is SubmoduleCommitHash)
                ) {
                    commitHash =
                        (r.resp as SubmoduleCommitHash).commitHash
                    commitTime =
                        (r.resp as SubmoduleCommitHash).commitTime
                    fetchTime = ((r as FetchResponse.Success<*>).resp as SubmoduleCommitHash).time
                }
            }
        }) {
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