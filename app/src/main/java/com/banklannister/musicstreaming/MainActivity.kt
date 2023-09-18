package com.banklannister.musicstreaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import com.banklannister.musicstreaming.data.songsList
import com.banklannister.musicstreaming.screen.HomeScreen
import com.banklannister.musicstreaming.ui.theme.MusicStreamingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicStreamingTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text(text = "Music Streaming App") },
                        Modifier.background(MaterialTheme.colors.primary)
                    )
                }) { innerPadding ->
                    HomeScreen(songsList = songsList, innerPadding)

                }
            }
        }
    }
}

