package com.Capstone.capstoneproject.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityAdoptPersianBinding
import com.Capstone.capstoneproject.databinding.ActivityClassificationBinding

class AdoptPersianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdoptPersianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdoptPersianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionbar =supportActionBar
        actionbar!!.title = "Adopt"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.btnAdoptus.setOnClickListener { adoptus() }
    }
    private fun adoptus() {
        Toast.makeText(this, "This feature is not yet available", Toast.LENGTH_SHORT).show()
    }
}