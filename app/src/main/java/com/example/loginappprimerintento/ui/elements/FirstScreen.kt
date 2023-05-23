package com.example.loginappprimerintento.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginappprimerintento.ui.state.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(modifier: Modifier = Modifier) {

    val loginViewModel : LoginViewModel = viewModel()

    if (!loginViewModel.loginScreen) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (loginViewModel.userName == "pepe" && loginViewModel.userPassword == "abc123.") {
                Text(text = "Sesión iniciada con éxito.")
            } else {
                Text(text = "Usuario o contraseña incorrectos.")
            }
        }
    } else {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(12.dp)) {
                //Text(text = "Usuario: ")
                OutlinedTextField(label = { Text("Usuario") },value = loginViewModel.userName, onValueChange = { loginViewModel.changeUserName(it) })
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp)) {
                //Text(text = "Contraseña: ")
                OutlinedTextField(visualTransformation = PasswordVisualTransformation(), label = { Text("Contraseña") },value = loginViewModel.userPassword, onValueChange = { loginViewModel.changeUserPassword(it) })
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp)) {
                Button(onClick = { loginViewModel.changeScreen(false)}) {
                    Text(text = "Iniciar sesión")
                }
            }
        }
    }
}