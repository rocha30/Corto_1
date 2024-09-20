package com.example.tic_tac_toe
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameScreen(player1: String, player2: String, boardSize: Int) {
    val game = remember { TicTacToeGame(boardSize) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Juego de Tic_Tac_Toe",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Jugador 1 (X): $player1")
        Text("Jugador 2 (O): $player2")

        Text(
            "Turno de: ${if (game.currentPlayer == "X") player1 else player2} (${game.currentPlayer})",
            fontWeight = FontWeight.Bold
        )

        Text("Estado: ${game.gameStatus}", color = Color.Blue)

        // Tablero de juego
        LazyVerticalGrid(
            columns = GridCells.Fixed(boardSize),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            items(boardSize * boardSize) { index ->
                val row = index / boardSize
                val col = index % boardSize
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(1.dp, Color.Black)
                        .clickable(
                            enabled = game.board[row][col].isEmpty() && game.gameStatus == "En curso",
                            onClick = {
                                game.makeMove(row, col)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = game.board[row][col],
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Botón para reiniciar el juego
        Button(
            onClick = { game.resetGame() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Reiniciar Juego")
        }
    }
}