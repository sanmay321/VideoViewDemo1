package com.example.videoviewdemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class splashScreen:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        var button = findViewById<Button>(R.id.button)
        supportActionBar?.hide()
        button.setOnClickListener(){
            Toast.makeText(this, "hi dude sanmay here", Toast.LENGTH_SHORT).show()
        }
        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}