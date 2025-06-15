package com.androidwithcomposetutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

/*@Composable
fun MainScreen(mainActivityViewModel: MainActivityViewModel = viewModel()) {
    mainActivityViewModel.counter.observeAsState().value.let {
        Log.d("MainScreen", "Value Gets Updated $it")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Button(onClick = { mainActivityViewModel.decrementCounter.invoke() }, modifier = Modifier.padding(5.dp)) {
                Text(text = "Decrement")
            }
            Text(text = "${mainActivityViewModel.counter.value}")

            Button(onClick = { mainActivityViewModel.incrementCounter.invoke() }) {
                Text(text = "Increment")
            }
        }
    }
}*/

@Composable
fun MainScreen(mainActivityViewModel: MainActivityViewModel = viewModel()) {
    val counterBackgroundColour by remember(mainActivityViewModel.counterNumber) {
        derivedStateOf {
            if (mainActivityViewModel.counterNumber % 2 == 0) Color.Red else Color.Green
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Button(
                onClick = { mainActivityViewModel.decrementCounterNumber() },
                modifier = Modifier.padding(5.dp),
                enabled = mainActivityViewModel.counterNumber != 0
            ) {
                Text(text = "Decrement")
            }
            Text(
                text = "${mainActivityViewModel.counterNumber}",
                modifier = Modifier
                    .background(counterBackgroundColour)
                    .width(50.dp)
                    .height(50.dp).padding(15.dp),
                textAlign = TextAlign.Center
                )

            Button(onClick = { mainActivityViewModel.incrementCounterNumber() }) {
                Text(text = "Increment")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}