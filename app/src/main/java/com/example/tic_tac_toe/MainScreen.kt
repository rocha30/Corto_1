package com.example.tic_tac_toe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen (onStartGame: (Int, String, String) -> Unit){
    var selectedSize by remember { mutableStateOf(3) }
    var player1Name by remember { mutableStateOf(TextFieldValue()) }
    var player2Name by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Bienvenido a Totito",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Selecciona el tamaño del tablero:",
            style = MaterialTheme.typography.bodyLarge
        )

        Row {
            RadioButton(
                selected = selectedSize == 3,
                onClick = { selectedSize = 3 }
            )
            Text("3x3", modifier = Modifier.align(Alignment.CenterVertically))

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = selectedSize == 4,
                onClick = { selectedSize = 4 }
            )
            Text("4x4", modifier = Modifier.align(Alignment.CenterVertically))

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = selectedSize == 5,
                onClick = { selectedSize = 5 }
            )
            Text("5x5", modifier = Modifier.align(Alignment.CenterVertically))
        }

        OutlinedTextField(
            value = player1Name,
            onValueChange = { player1Name = it },
            label = { Text("Nombre del Jugador 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = player2Name,
            onValueChange = { player2Name = it },
            label = { Text("Nombre del Jugador 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (player1Name.text.isNotEmpty() && player2Name.text.isNotEmpty()) {
                    onStartGame(selectedSize, player1Name.text, player2Name.text)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Iniciar Juego")
        }
    }
}


