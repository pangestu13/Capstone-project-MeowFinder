    package com.Capstone.resetpassword

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Patterns
    import android.widget.Toast
    import com.Capstone.capstoneproject.R
    import com.Capstone.capstoneproject.databinding.ActivityCreateaccountBinding
    import com.Capstone.capstoneproject.databinding.ActivityLoginBinding
    import com.Capstone.capstoneproject.databinding.ActivityResetPasswordBinding
    import com.google.firebase.auth.FirebaseAuth
    import java.util.regex.Pattern

    class ResetPasswordActivity : AppCompatActivity() {

        private lateinit var binding: ActivityResetPasswordBinding
        private lateinit var auth: FirebaseAuth
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityResetPasswordBinding.inflate(layoutInflater)
            setContentView(binding.root)

            auth = FirebaseAuth.getInstance()

            binding.btnAturulangpwbt.setOnClickListener {
                val email = binding.emailEditText.text.toString().trim()

                if (email.isEmpty()) {
                    binding.emailEditText.error = "Email harus diisi"
                    return@setOnClickListener
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.emailEditText.error = "Email tidak valid"
                    return@setOnClickListener
                }

                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener{ task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Email reset password telah dikirim", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this, "Gagal mengirim email reset password", Toast.LENGTH_SHORT).show()
                        }
                    }


            }

        }
    }