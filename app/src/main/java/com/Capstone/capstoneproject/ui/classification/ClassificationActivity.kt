package com.Capstone.capstoneproject.ui.classification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityClassificationBinding
import com.Capstone.capstoneproject.ui.Camera.KameraFragment
import com.Capstone.capstoneproject.ui.ViewModelFactory
import com.bumptech.glide.Glide


class ClassificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassificationBinding
    private val viewModel by viewModels<ClassificationViewModel> {
        ViewModelFactory.getInstance(
            application
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionbar =supportActionBar
        actionbar!!.title = "Cat Creeds"

        binding = ActivityClassificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUri = intent.getStringExtra(KameraFragment.EXTRA_IMAGE_URI)
        imageUri?.let {
            viewModel.imageUri.value = it
            viewModel.classification(it)

            binding.btnSaveChange.setOnClickListener { adoptus() }
        }

        viewModel.isLoading.observe(this) {
            binding.loadingBar.visibility = if (it) View.VISIBLE else View.GONE
            binding.linearLayout.visibility = if (it) View.GONE else View.VISIBLE
        }

        viewModel.result.observe(this) {
            if (it != null) {
                binding.catName.text = it.ras
                binding.catDescription.text = it.deskripsi
                Glide.with(this).load(it.foto).error(R.drawable.ic_place_holder)
                    .into(binding.catImage)
            }
        }
    }
    private fun adoptus() {
        Toast.makeText(this, "This feature is not yet available", Toast.LENGTH_SHORT).show()
    }
}