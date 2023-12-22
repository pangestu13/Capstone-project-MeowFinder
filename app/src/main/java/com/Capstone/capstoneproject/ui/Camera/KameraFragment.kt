package com.Capstone.capstoneproject.ui.Camera

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.Capstone.capstoneproject.databinding.FragmentKameraBinding
import getImageUri
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.api.ApiConfig
import com.Capstone.capstoneproject.ui.classification.ClassificationActivity
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException
import uriToFile


class KameraFragment : Fragment() {


    private var _binding: FragmentKameraBinding? = null
    private val binding get() = _binding
    private var currentImageUri: Uri? = null

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(requireActivity(), "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireActivity(), "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            requireActivity(),
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED


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
            Log.d("Image URI", "showImage: $uri")
            val intent = Intent(requireActivity(), ClassificationActivity::class.java)
            intent.putExtra(EXTRA_IMAGE_URI, uri.toString())
            startActivity(intent)

        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }
    //kamera
    private fun startCamera() {
        currentImageUri = getImageUri(requireActivity())
        launcherIntentCamera.launch(currentImageUri)
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            currentImageUri?.let {

                Log.d("Image URI", "showImage: $it")
                val intent = Intent(requireActivity(), ClassificationActivity::class.java)
                intent.putExtra(EXTRA_IMAGE_URI, it.toString())
                startActivity(intent)
            }
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

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
        const val EXTRA_IMAGE_URI = "IMAGE_URI"
    }



}
