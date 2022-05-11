package com.example.memorygame.utils

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import androidx.annotation.RawRes

class Media private constructor() {
    var mMediaPlayer: MediaPlayer? = null

    companion object {
        var media: Media? = null
        fun getInstance() {
            if (media == null) {
                media = Media()
            }
        }
    }

    fun play(context: Context, @RawRes raw: Int) {
        mMediaPlayer?.stop()
        mMediaPlayer = MediaPlayer.create(context, raw)
        mMediaPlayer?.start()
    }
    fun pause(){
        mMediaPlayer?.pause()
    }
    fun stop(){
        mMediaPlayer?.stop()
    }
    fun resume(){
//        mMediaPlayer
    }
}