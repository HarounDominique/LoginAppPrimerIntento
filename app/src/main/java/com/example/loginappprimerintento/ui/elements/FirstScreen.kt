package com.example.loginappprimerintento.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen() {

    if (!loginScreen) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (userName == "pepe" && userPassword == "abc123") {
                Text(text = "Sesión iniciada con éxito.")
            } else {
                Text(text = "Usuario o contraseña incorrectos.")
            }
        }
    } else {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(text = "Usuario: ")
                TextField(value = userName, onValueChange = { userName = it })
            }
            Row() {
                Text(text = "Contraseña: ")
                TextField(value = userPassword, onValueChange = { userPassword = it })
            }
            Row() {
                Button(onClick = { loginScreen = false }) {
                    Text(text = "Iniciar sesión")
                }
            }
        }
    }
}