package com.Capstone.capstoneproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.Capstone.capstoneproject.databinding.ActivityEditProfileBinding
import kotlinx.coroutines.NonCancellable.start

class EditProfileActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        _binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setupAction(_binding.root)
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?
//    ): View? {
//        _binding = ActivityEditProfileBinding. inflate(inflater, container, false)
//        return binding?.root
//    }

    private fun setupAction(root: ConstraintLayout) {
        _binding.let { bind ->
            bind.btnSaveChange.setOnClickListener {
                startActivity((Intent(this,ProfileFragment::class.java)))
            }
        }
    }


}

