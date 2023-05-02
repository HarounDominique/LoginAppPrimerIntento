package com.example.loginappprimerintento.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun ViewModel(){
    var userName by rememberSaveable {
        mutableStateOf("")
    }
    var userPassword by rememberSaveable {
        mutableStateOf("")
    }
    var loginScreen by rememberSaveable {
        mutableStateOf(true)
    }
}