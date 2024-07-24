package com.Capstone.getstarted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityGetstartBinding
import com.Capstone.capstoneproject.databinding.ActivityMainBinding
import com.Capstone.logined.LoginActivity

class getstartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetstartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetstartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.getstartbt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}