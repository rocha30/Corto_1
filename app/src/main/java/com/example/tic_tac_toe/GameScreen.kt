package com.example.tic_tac_toe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(player1: String, player2: String, boardSize: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Juego de Totito",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Jugador 1: $player1")
        Text("Jugador 2: $player2")
        Text("Tamaño del tablero: ${boardSize}x$boardSize")

        // Aquí irá el tablero del juego en futuras implementaciones
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                "Tablero ${boardSize}x$boardSize",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen() {
    GameScreen(player1 = "Antonio", player2 = "Jugador 2", boardSize = 3)
}