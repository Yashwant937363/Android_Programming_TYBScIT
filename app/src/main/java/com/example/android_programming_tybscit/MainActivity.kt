@file:Suppress("DEPRECATION")

package com.example.android_programming_tybscit

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        val selectItem = BottomNavigationView.OnNavigationItemSelectedListener {
            item ->
                if(item.itemId == R.id.videos){
                    openFragment(VideoFragment())
                    return@OnNavigationItemSelectedListener true
                }
                else if(item.itemId == R.id.quiz) {
                    openFragment(QuizFragment())
                    return@OnNavigationItemSelectedListener true
                }
                else if(item.itemId == R.id.notes) {
                    openFragment(NotesFragment())
                    return@OnNavigationItemSelectedListener true
                }
                return@OnNavigationItemSelectedListener false
        }
        findViewById<BottomNavigationView>(R.id.navigation).setOnNavigationItemSelectedListener(selectItem)
    }
    private fun openFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit()
    }
}