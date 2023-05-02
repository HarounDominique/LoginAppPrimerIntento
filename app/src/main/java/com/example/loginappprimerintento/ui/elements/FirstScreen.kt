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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginappprimerintento.ui.state.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen() {

    val LoginViewModel : LoginViewModel = viewModel()

    if (!LoginViewModel.loginScreen) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (LoginViewModel.userName == "pepe" && LoginViewModel.userPassword == "abc123") {
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
                TextField(value = LoginViewModel.userName, onValueChange = { LoginViewModel.changeUserName(it) })
            }
            Row() {
                Text(text = "Contraseña: ")
                TextField(value = LoginViewModel.userPassword, onValueChange = { userPassword = it })
            }
            Row() {
                Button(onClick = { loginScreen = false }) {
                    Text(text = "Iniciar sesión")
                }
            }
        }
    }
}