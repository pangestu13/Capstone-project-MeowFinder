package com.Capstone.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.FragmentProfileBinding
import com.Capstone.logined.LoginActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var btnIntent: Button
    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("Users")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnIntent = view.findViewById(R.id.btn_edit_profile)
        btnIntent.setOnClickListener(this)

        binding.btnLogout.setOnClickListener {
            auth.signOut()

            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        fetchUserData()

    }

    private fun fetchUserData() {
        val currentUser = auth.currentUser
        if (currentUser != null){
            val userId = currentUser.uid
            db.child(userId)
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val username = snapshot.child("username").value
                        val email = snapshot.child("email").value
                        val profileImage = snapshot.child("profileImage").value

                        // Update UI with retrieved data
                        binding.idUsername.text = username.toString()
                        binding.idEmail.text = email.toString()
                        // Load profile image using Glide or Picasso
                        Glide.with(this@ProfileFragment)
                            .load(profileImage)
                            .placeholder(R.drawable.photo_profile)
                            .into(binding.ivImageProfile)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_edit_profile -> run{
                val intentku = Intent(requireContext(), EditProfileActivity::class.java)
                startActivity(intentku)
            }
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }




}