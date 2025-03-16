package com.example.android_programming_tybscit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.linarlayoutbtn).setOnClickListener { startActivity(Intent(this,Linear::class.java )) }
        findViewById<Button>(R.id.relative_layout_btn).setOnClickListener { startActivity(Intent(this,Relative::class.java )) }
        findViewById<Button>(R.id.listviewbtn).setOnClickListener { startActivity(Intent(this,ListViewLayout::class.java )) }

    }
}