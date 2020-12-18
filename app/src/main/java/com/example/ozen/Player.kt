package com.example.ozen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_podcasts.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_player.*

class Podcasts : AppCompatActivity() {

    private lateinit var mplayer: MediaPlayer
    private lateinit var runnable:Runnable
    private var pause:Boolean = false
    private var handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
/*******************************************************/
        tolist.setOnClickListener {
            val intent = Intent (this, ListCard::class.java)
            startActivity(intent)
        }

        //Включение песни
        play_song.setOnClickListener {
            if (pause){
                mplayer.seekTo(mplayer.currentPosition)
                mplayer.start()
                pause = false
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()
            }else{
                mplayer = MediaPlayer.create(applicationContext, R.raw.david_roy_song)
                mplayer.start()
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()
            }
            initializeSeekBar()
            play_song.isEnabled = false
            pause_song.isEnabled = true
            stop_song.isEnabled = true

            mplayer.setOnCompletionListener {
                play_song.isEnabled = true
                pause_song.isEnabled = false
                stop_song.isEnabled = false
                Toast.makeText(this, "end", Toast.LENGTH_SHORT).show()
            }
        }
        //Пауза
        pause_song.setOnClickListener {
            if (mplayer.isPlaying) {
                mplayer.pause()
                pause = true
                play_song.isEnabled = true
                pause_song.isEnabled = false
                stop_song.isEnabled = true
                Toast.makeText(this, "media pause", Toast.LENGTH_SHORT).show()
            }
        }
        //Stop the media player
        stop_song.setOnClickListener {
            if (mplayer.isPlaying || pause.equals(true)){
                pause = false
                seek_bar.setProgress(0)
                mplayer.stop()
                mplayer.reset()
                mplayer.release()
                handler.removeCallbacks(runnable)

                play_song.isEnabled = true
                pause_song.isEnabled = false
                stop_song.isEnabled = false
                tv_pass.text = ""
                tv_due.text = ""
                Toast.makeText(this, "media stop", Toast.LENGTH_SHORT).show()
            }
        }
        //Seek bar change listener
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b){
                    mplayer.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

    }
    //Method to initialize seek bar and audio stats
    private fun initializeSeekBar() {
        seek_bar.max = mplayer.seconds

        runnable = Runnable {
            seek_bar.progress = mplayer.currentSeconds
            tv_pass.text = "${mplayer.currentSeconds} sec"
            val diff = mplayer.seconds - mplayer.currentSeconds
            tv_due.text = "$diff sec"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }

}
//Creating ana extension property to get media player time
val MediaPlayer.seconds:Int
    get() {
        return this.duration / 1000
    }

//Creating an extension property to get media player current position in seconds
val MediaPlayer.currentSeconds:Int
    get() {
        return this.currentPosition/1000
    }
