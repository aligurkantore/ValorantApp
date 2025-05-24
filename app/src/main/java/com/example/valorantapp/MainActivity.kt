package com.example.valorantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.valorantapp.ui.screen.main.MainScreen
import com.example.valorantapp.ui.theme.ValorantAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                val navController = rememberNavController()
                MainScreen(navController = navController)
            }
        }
    }
}
