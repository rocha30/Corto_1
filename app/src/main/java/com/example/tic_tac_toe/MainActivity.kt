package com.example.tic_tac_toe

import android.widget.Toast
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.material3.Surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    Navigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MainScreen { _, _, _ -> }
    }
}