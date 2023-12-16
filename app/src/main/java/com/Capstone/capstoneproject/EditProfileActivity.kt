package com.Capstone.capstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext

class EditProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntentku: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        btnIntentku =  findViewById(R.id.btn_back_home)
        btnIntentku.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_back_home -> run{
                val intentk = Intent(this, MainActivity::class.java)
                startActivity(intentk)
            }
        }

    }
}