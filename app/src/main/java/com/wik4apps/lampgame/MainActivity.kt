package com.wik4apps.lampgame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var lampOff = true
    var lampCrecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgLamp = findViewById<ImageView>(R.id.imageView)
        val btn = findViewById<Button>(R.id.button)
        imgLamp.setOnLongClickListener ({
            val mp = MediaPlayer.create(this, R.raw.crash)
            mp.start()
            lampCrecked = true
            imgLamp.setImageResource(R.drawable.lamp_cr)
            btn.visibility = View.VISIBLE
            true
        })
    }

    fun onClickLamp(view: View) {
        //play sound on click using media player
        val mediaPlayer = MediaPlayer.create(this, R.raw.click)

        val imageView = view as ImageView  //cast view to image view
        if (lampOff && !lampCrecked) {
            imageView.setImageResource(R.drawable.lamp_on)
            lampOff = false
            mediaPlayer.start()
        } else if (!lampOff && !lampCrecked) {
            imageView.setImageResource(R.drawable.lamp_of)
            lampOff = true
            mediaPlayer.start()
        }
    }

    fun onBtnClick(view: View) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (lampCrecked) {
            imageView.setImageResource(R.drawable.lamp_of)
            lampOff = true
            lampCrecked = false
        }
        (view as Button).visibility = View.INVISIBLE
    }
}