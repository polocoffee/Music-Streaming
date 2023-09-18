package com.banklannister.musicstreaming.helper

import android.media.MediaPlayer

class SongHelper {
    companion object {
        private var mediaPlayer: MediaPlayer? = null
        private var currentPosition = 0

        fun playSteam(url: String) {
            mediaPlayer?.let {
                if (it.isPlaying) {
                    mediaPlayer?.stop()
                    mediaPlayer?.reset()
                }
            }
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                prepareAsync()
            }

            mediaPlayer?.setOnPreparedListener { mediaPlayer ->
                mediaPlayer.seekTo(currentPosition)
                mediaPlayer.start()
            }
        }

        fun pauseStream() {
            mediaPlayer?.let {
                currentPosition = it.currentPosition
                it.pause()
            }
        }

        fun stopStream() {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            currentPosition = 0
        }

        fun releasePlayer() {
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
            currentPosition = 0
        }
    }
}