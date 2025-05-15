package com.example.najwahafidz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.najwahafidz.ui.AppNavHost
import com.example.najwahafidz.ui.theme.NajwahafidzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NajwahafidzTheme {
                AppNavHost()
            }
        }
    }
}
