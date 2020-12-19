package com.example.proyectosemestralsensoreshpa42020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
    }
}
