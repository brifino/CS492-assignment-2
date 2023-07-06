/**
 *  Assignment 2 / Simple Interactive App
 *
 *  Brahm Rifino / rifinob@oregonstate.edu
 *  CS492 / Oregon State University
 */




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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
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
    var count by remember { mutableStateOf(3) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(75.dp))
        Image(
            painter = painterResource(id = R.drawable.dissc),
            contentDescription = "App Logo",
            modifier = Modifier.size(325.dp)
                //.weight(1f)
                .shadow(5.dp)
                .border(10.dp, Color.White)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text("Current Count: $count", fontSize = (36.sp))
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .background(color = Color(0xFFe3fcff))
                .border(width = 2.dp, color = Color.Black)
                .padding(15.dp)
                .width(300.dp)
                .height(50.dp)
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text("Disc Golf", fontSize = (18.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Text("Brahm Rifino ", fontSize = (14.sp), fontWeight = FontWeight.Bold)
                    Text("(CS 492)", fontSize = (14.sp))
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row( modifier = Modifier.padding(bottom = 16.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                onClick = {
                    if (count == 1) count = 5 else count--
                }
            ) {
                Text(text = "Previous", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(45.dp))
            Button(
                onClick = {
                    if (count == 5) count = 1 else count++
                },
                modifier = Modifier.width(150.dp)
            ) {
                Text(text = "Next", fontSize = 24.sp)
            }
        }
    }
}