package com.example.android_programming_tybscit

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION")
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
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if(networkInfo != null && networkInfo.isConnected){
            if(networkInfo.type == ConnectivityManager.TYPE_MOBILE)
                makeToast("Connected to Mobile Data")
            else if(networkInfo.type == ConnectivityManager.TYPE_WIFI)
                makeToast("Connected to Wifi Data")
        }else {
            makeToast("Offline")
        }
    }
    private fun makeToast(str:String){
        Toast.makeText(applicationContext, str , Toast.LENGTH_LONG).show()
    }

}