package com.banklannister.musicstreaming.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.banklannister.musicstreaming.data.Song
import com.banklannister.musicstreaming.helper.SongHelper

@Composable
fun SongsList(songsList: List<Song>, onSongSelected: (song: Song) -> Unit) {
    var isSongSelected by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = if (isSongSelected) {
                    48.dp
                } else {
                    4.dp
                }
            )
    ) {
        items(songsList) { song ->
            SongCard(song = song, onClick = {
                isSongSelected = true
                SongHelper.stopStream()
                onSongSelected(song)
            })
        }
    }
}