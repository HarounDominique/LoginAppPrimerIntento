package com.example.loginappprimerintento.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginappprimerintento.ui.state.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(paddingValues: PaddingValues) {

    val LoginViewModel : LoginViewModel = viewModel()

    if (!LoginViewModel.loginScreen) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (LoginViewModel.userName == "pepe" && LoginViewModel.userPassword == "abc123.") {
                Text(text = "Sesión iniciada con éxito.")
            } else {
                Text(text = "Usuario o contraseña incorrectos.")
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(12.dp)) {
                //Text(text = "Usuario: ")
                OutlinedTextField(label = { Text("Usuario") },value = LoginViewModel.userName, onValueChange = { LoginViewModel.changeUserName(it) })
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp)) {
                //Text(text = "Contraseña: ")
                OutlinedTextField(visualTransformation = PasswordVisualTransformation(), label = { Text("Contraseña") },value = LoginViewModel.userPassword, onValueChange = { LoginViewModel.changeUserPassword(it) })
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(12.dp)) {
                Button(onClick = { LoginViewModel.changeScreen(false)}) {
                    Text(text = "Iniciar sesión")
                }
            }
        }
    }
}