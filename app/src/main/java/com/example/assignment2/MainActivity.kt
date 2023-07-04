package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    HandleCount(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )

}

@Composable
fun HandleCount(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(1) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(500.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                onClick = {
                    count -= 1
                    if(count < 0){
                        count = 0
                    }}
            ) {
                Text(text = "Previous", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(90.dp))
            Button(
                onClick = {
                    count += 1
                    if (count > 5) {
                        count = 1
                    }
                },
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(text = "Next", fontSize = 24.sp)
            }
        }
    }
}