package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.signin.SignInScreen
import com.example.myapplication.signin.SignUpScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var isSignIn by remember { mutableStateOf(true) }

                if (isSignIn) {
                    SignInScreen(onToggle = { isSignIn = !isSignIn })
                } else {
                    SignUpScreen(onToggle = { isSignIn = !isSignIn })
                }
            }
        }
    }
}
