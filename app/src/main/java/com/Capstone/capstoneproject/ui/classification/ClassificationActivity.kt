package com.Capstone.capstoneproject.ui.classification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.viewModels
import androidx.core.net.toUri
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityClassificationBinding
import com.Capstone.capstoneproject.databinding.FragmentKameraBinding
import com.Capstone.capstoneproject.ui.Camera.KameraFragment
import com.Capstone.capstoneproject.ui.ViewModelFactory
import java.util.zip.Inflater

class ClassificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassificationBinding
    private val viewModel by viewModels<ClassificationViewModel>{ViewModelFactory.getInstance(application)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUri = intent.getStringExtra(KameraFragment.EXTRA_IMAGE_URI)
        imageUri?.let {
            viewModel.imageUri.value = it
        }


    }
}