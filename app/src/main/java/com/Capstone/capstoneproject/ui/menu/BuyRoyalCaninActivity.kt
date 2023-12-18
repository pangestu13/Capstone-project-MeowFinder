package com.Capstone.capstoneproject.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R

class BuyRoyalCaninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_royal_canin)

        val actionbar =supportActionBar
        actionbar!!.title = "Buy Item"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}