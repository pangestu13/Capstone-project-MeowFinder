package com.Capstone.capstoneproject.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityBuyItemBinding

class BuyWhiskas : AppCompatActivity() {

    private lateinit var _binding: ActivityBuyItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_item)
        val actionbar =supportActionBar
        actionbar!!.title = "Buy Item"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        _binding = ActivityBuyItemBinding.inflate(layoutInflater)
        setupAction(_binding.root)

    }

    private fun setupAction(root: ConstraintLayout) {
//        _binding.let { bind ->
//            bind.btnBackHome.setOnClickListener {
//                val intentk = Intent(this, MainActivity::class.java)
//                startActivity(intentk)
////        }
//
//    }
}}