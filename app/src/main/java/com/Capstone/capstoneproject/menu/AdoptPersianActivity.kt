package com.Capstone.capstoneproject.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R

class AdoptPersianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_persian)

        val actionbar =supportActionBar
        actionbar!!.title = "Adopt"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}