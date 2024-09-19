package com.example.tic_tac_toe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    MainScreen { size, player1, player2 ->
                        // Aquí es donde iniciarías la actividad del juego
                        // Por ahora, solo mostraremos un Toast
                        Toast.makeText(
                            this@MainActivity,
                            "Iniciando juego: Tablero ${size}x$size, Jugadores: $player1 vs $player2",
                            Toast.LENGTH_LONG
                        ).show()
                    }
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