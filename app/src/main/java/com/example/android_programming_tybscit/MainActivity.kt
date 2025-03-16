package com.example.android_programming_tybscit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val Tag = "MyMessage"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.about_us).setOnClickListener {
            startActivity(Intent(this, AboutUs::class.java))
        }
        makeLog("Create")
    }

    override fun onResume() {
        super.onResume()
        makeLog("Resumed")
    }

    override fun onRestart() {
        super.onRestart()
        makeLog("Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        makeLog("Destroy")
    }

    override fun onStart() {
        super.onStart()
        makeLog("Start")
    }

    override fun onPause() {
        super.onPause()
        makeLog("Pause")
    }

    override fun onStop() {
        super.onStop()
        makeLog("Stop")
    }

    private fun makeLog(message:String){
        Log.d(Tag, "Main "+ message)
    }
}