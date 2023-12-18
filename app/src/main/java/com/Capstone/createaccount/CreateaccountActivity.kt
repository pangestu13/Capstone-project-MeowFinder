package com.Capstone.createaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityCreateaccountBinding
import com.Capstone.logined.LoginActivity

class CreateaccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateaccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateaccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.masuktv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}