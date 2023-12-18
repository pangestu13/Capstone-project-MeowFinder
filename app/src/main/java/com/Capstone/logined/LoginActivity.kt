package com.Capstone.logined

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityCreateaccountBinding
import com.Capstone.capstoneproject.databinding.ActivityLoginBinding
import com.Capstone.createaccount.CreateaccountActivity
import com.Capstone.resetpassword.ResetPasswordActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.buatakuntv.setOnClickListener {
            startActivity(Intent(this, CreateaccountActivity::class.java))
        }

        binding.lupapwtv.setOnClickListener {
            startActivity(Intent(this, ResetPasswordActivity::class.java))
        }
    }
}