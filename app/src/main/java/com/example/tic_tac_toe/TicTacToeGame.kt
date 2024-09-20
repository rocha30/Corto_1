package com.example.tic_tac_toe

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class TicTacToeGame(private val boardSize: Int) {
    var board by mutableStateOf(List(boardSize) { List(boardSize) { "" } })
    var currentPlayer by mutableStateOf("X")
    var gameStatus by mutableStateOf("En curso")

    fun makeMove(row: Int, col: Int): Boolean {
        if (board[row][col].isNotEmpty() || gameStatus != "En curso") return false

        val newBoard = board.toMutableList().map { it.toMutableList() }
        newBoard[row][col] = currentPlayer
        board = newBoard

        if (checkWinner(row, col)) {
            gameStatus = "¡$currentPlayer ha ganado!"
        } else if (board.all { row -> row.all { it.isNotEmpty() } }) {
            gameStatus = "¡Empate!"
        } else {
            currentPlayer = if (currentPlayer == "X") "O" else "X"
        }

        return true
    }

    private fun checkWinner(row: Int, col: Int): Boolean {
        val symbol = board[row][col]

        if (board[row].all { it == symbol }) return true
        if (board.all { it[col] == symbol }) return true
        if (row == col && (0 until boardSize).all { board[it][it] == symbol }) return true
        if (row + col == boardSize - 1 && (0 until boardSize).all { board[it][boardSize - 1 - it] == symbol }) return true

        return false
    }

    fun resetGame() {
        board = List(boardSize) { List(boardSize) { "" } }
        currentPlayer = "X"
        gameStatus = "En curso"
    }
}

