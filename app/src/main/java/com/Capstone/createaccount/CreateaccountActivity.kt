package com.Capstone.createaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityCreateaccountBinding
import com.Capstone.logined.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class CreateaccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateaccountBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateaccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnCreateAccount.setOnClickListener{
            val email = binding.emailEditText.text.toString()
            val name = binding.fullnameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmpasswordEditText.text.toString()

            if (email != "" && name != "" && password != "" && confirmPassword != ""){
                if (password == confirmPassword){
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener{
                            if (it.isSuccessful){
                                val uid = auth.currentUser!!.uid

                                val hashMap : HashMap<String, Any> = HashMap()
                                hashMap["email"] = "$email"
                                hashMap["name"] = "$name"
                                hashMap["password"] = "$password"

                                val ref = FirebaseDatabase.getInstance().getReference("User")
                                ref.child(auth.uid!!)
                                    .updateChildren(hashMap)

                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            } else {
                                Log.e(this.toString(), it.exception.toString())
                            }
                        }
                } else {
                    Toast.makeText(this, "Password berbeda", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Terdapat kolom yang belum terisi", Toast.LENGTH_SHORT).show()
            }
        }

        setupAction()
    }

    private fun setupAction() {
        binding.masuktv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}