package com.Capstone.capstoneproject.ui

import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityEditProfileBinding
import com.Capstone.capstoneproject.ui.home.MainActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference
    private var imageUri: Uri?=null
    private lateinit var  progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")

        progressDialog.setCanceledOnTouchOutside(false)

        auth = FirebaseAuth.getInstance()
        loadUser()

        binding.ivImageProfile.setOnClickListener{
            showImageMenu()
        }

        binding.btnSaveChange.setOnClickListener{
            checkData()
        }
    }

    private fun loadUser() {
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(auth.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val profileImage = "${snapshot.child("profileImage").value}"


                    try {
                        Glide
                            .with(this@EditProfileActivity)
                            .load(profileImage)
                            .placeholder(R.drawable.photo_profile)
                            .into(binding.ivImageProfile)
                    } catch (e: Exception){

                    }
                }
                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private var name = ""
    private var username = ""
    private var email = ""
    private fun checkData() {
        name = binding.nameEt.text.toString().trim()
        username  = binding.usernameEt.text.toString().trim()
        email = binding.emailEt.text.toString().trim()

        if (name == "" && username == "" && email == "" ){
            Toast.makeText(this, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else{
            if (imageUri == null){
                updateProfile("")
            } else {
                uploadImage()
            }
        }
    }

    private fun uploadImage() {
        progressDialog.setMessage("Uploading Image Profile")
        progressDialog.show()

        val filePathAndName = "ProfileImages/${auth.uid}"

        val reference = FirebaseStorage.getInstance().getReference(filePathAndName)

        reference.putFile(imageUri!!)
            .addOnSuccessListener { taskSnapshot ->
                // Dismiss progress dialog immediately
                progressDialog.dismiss()

                // Get download URL directly without blocking
                reference.downloadUrl.addOnSuccessListener { uploadedImageUrl ->
                    updateProfile(uploadedImageUrl.toString())
                }.addOnFailureListener { e ->
                    Toast.makeText(this, "Failed to get download URL: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed to upload image: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateProfile(uploadedImageUrl: String) {
        progressDialog.setMessage("Updating Profile")

        val hashmap : HashMap<String, Any> = HashMap()
        hashmap["name"] = "$name"
        hashmap["username"] = "$username"
        hashmap["email"] = "$email"
        if (imageUri != null) {
            hashmap["profileImage"] = uploadedImageUrl
        }

        val reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(auth.uid!!)
            .updateChildren(hashmap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{e->
                progressDialog.dismiss()
                Toast.makeText(this, "Gagal mengupdate profile ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

    private fun showImageMenu() {
        val popupMenu = PopupMenu(this, binding.ivImageProfile)
        popupMenu.menu.add(Menu.NONE, 0, 0, "Camera")
        popupMenu.menu.add(Menu.NONE, 1, 1, "Gallery")
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item->
            val id = item.itemId
            if (id == 0){
                pickImageCamera()
            } else if (id == 1){
                pickImageGallery()
            }

            true
        }

    }

    private fun pickImageCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "Temp_Title")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Temp_Description")

        imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        cameraActivityResultLauncher.launch(intent)
    }

    private val cameraActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult>{result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data

                binding.ivImageProfile.setImageURI(imageUri)
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    )

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResultLauncher.launch(intent)
    }

    private val galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data
                imageUri = data!!.data
                binding.ivImageProfile.setImageURI(imageUri)
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
    })
}