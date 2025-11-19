package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                NavigationComponent()

            }
        }
    }
}

@Composable
fun NavigationComponent(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "screen_one"
    ){
        composable("screen_one") {
            ScreenOne(
                onNavigateToTwo = {
                    navController.navigate("screen_two")
                }
            )
        }
        composable("screen_two") {
            ScreenTwo(
                onNavigateBack = {
                    navController.navigate("screen_one")
                }
            )
        }
    }

}

