package com.example.loginappprimerintento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginappprimerintento.ui.elements.FirstScreen
import com.example.loginappprimerintento.ui.state.LoginViewModel
import com.example.loginappprimerintento.ui.theme.LoginAppPrimerIntentoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel: LoginViewModel = viewModel();
            LoginAppPrimerIntentoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        //modifier = Modifier.padding(),
                        topBar = {
                            TopAppBar(title = { Text("Login Menu") },
                                actions = {
                                    IconButton(onClick = {
                                        loginViewModel.changeScreen(true);
                                        loginViewModel.changeUserPassword("");
                                        loginViewModel.changeUserName("")
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Refresh,
                                            contentDescription = "Refresh"
                                        )
                                    }
                                }
                            )
                        },
                        content = { FirstScreen(modifier = Modifier.padding(it)) }
                    )

                }
            }
        }
    }
}


