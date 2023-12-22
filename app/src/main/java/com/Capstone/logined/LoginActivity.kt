package com.Capstone.logined

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityCreateaccountBinding
import com.Capstone.capstoneproject.databinding.ActivityLoginBinding
import com.Capstone.capstoneproject.ui.home.MainActivity
import com.Capstone.createaccount.CreateaccountActivity
import com.Capstone.resetpassword.ResetPasswordActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.loginbt.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email != "" && password != ""){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Gagal Login ${it.exception.toString()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Ada yang belum diisi!!!", Toast.LENGTH_SHORT).show()
            }
        }


        setupAction()
    }

    override fun onStart() {
        super.onStart()

        if (auth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
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