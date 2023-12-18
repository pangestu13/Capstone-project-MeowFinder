package com.Capstone.resetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityCreateaccountBinding
import com.Capstone.capstoneproject.databinding.ActivityLoginBinding
import com.Capstone.capstoneproject.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}