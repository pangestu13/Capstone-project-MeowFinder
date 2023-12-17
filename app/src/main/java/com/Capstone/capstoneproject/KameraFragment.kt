package com.Capstone.capstoneproject

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.Capstone.capstoneproject.databinding.FragmentKameraBinding
import getImageUri


class KameraFragment : Fragment(), View.OnClickListener{


    private var _binding: FragmentKameraBinding? = null
    private val binding get() = _binding
    private var currentImageUri: Uri? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKameraBinding.inflate(inflater, container, false)
        return _binding?.root


    }

    //galeri
    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }
    //kamera
    private fun startCamera() {

        launcherIntentCamera.launch(currentImageUri)
    }
    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnTakeGaleri?.setOnClickListener { startGallery() }
        binding?.btnTakeFoto?.setOnClickListener { startCamera() }

    }

    override fun onClick(v: View) {

    }



}
