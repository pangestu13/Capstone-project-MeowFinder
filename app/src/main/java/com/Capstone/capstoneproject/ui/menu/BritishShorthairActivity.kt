package com.Capstone.capstoneproject.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R

class BritishShorthairActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_british_shorthair)
        val actionbar =supportActionBar
        actionbar!!.title = "Adopt"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}