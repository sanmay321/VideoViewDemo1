package com.example.videoviewdemo

import android.content.ContentResolver
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    var simpleVideoView: VideoView? = null
    var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.hide()


        simpleVideoView = findViewById<VideoView>(R.id.video)

        simpleVideoView!!.setVideoURI(Uri.parse("android.resource://"
                + packageName + "/" + R.raw.sanmay123))

        simpleVideoView!!.setOnCompletionListener {     simpleVideoView!!.start() }

//        if (savedInstanceState != null) {
//            var position = savedInstanceState.getInt("position")
//            simpleVideoView!!.seekTo(position)
//        }


    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onStart() {
        super.onStart()
        if (currentPosition != 0)
            simpleVideoView!!.seekTo(currentPosition)

        simpleVideoView!!.start()

    }

    override fun onResume() {
        super.onResume()
        if (!simpleVideoView!!.isPlaying) {
            if (currentPosition != 0)
                simpleVideoView!!.seekTo(currentPosition)

            simpleVideoView!!.start()
        }
    }

    override fun onPause() {
        super.onPause()
        simpleVideoView!!.pause()
        currentPosition = simpleVideoView!!.currentPosition
    }

    override fun onStop() {
        simpleVideoView!!.pause()
        super.onStop()
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putInt("position", currentPosition)
//        super.onSaveInstanceState(outState)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val videoView = findViewById<VideoView>(R.id.video)
//        val mediaController = MediaController(this)
//        mediaController.setAnchorView((videoView))
//        val uri : Uri = parse("ansdroid.resourse://"+packageName+"/"+R.raw.sanmay123)
//        videoView.setMediaController(mediaController)
//        videoView.setVideoURI(uri)
//        videoView!!.requestFocus()
//        videoView!!.start()
//        videoView!!.setOnCompletionListener { videoView!!.start() }
//
////        videoView.setVideoURI(uri)
////        videoView.setOnPreparedListener(MediaPlayer.OnPreparedListener(){
////            fun onPre
////        })
//    }
    hi this is sanmay
}