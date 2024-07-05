package com.kunal.chateo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.kunal.chateo.ui.ChateoApp
import com.kunal.chateo.ui.theme.ChateoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChateoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChateoApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}