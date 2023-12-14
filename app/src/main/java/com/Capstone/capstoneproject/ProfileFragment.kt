package com.Capstone.capstoneproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.Capstone.capstoneproject.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(), View.OnClickListener{

    private var _binding: FragmentProfileBinding? = null
    private lateinit var btneditprofile: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
//        btneditprofile = findViewById(R.id.edit_profile)
//        btneditprofile = setOnCliclistener {
//            val intent = Intent(this, EditProfileActivity::class.java)
//            StartAntivity(intent)
//        }

//        val btnmusclesholder :Button = findViewById(R.id.edit_profile)
//        btnmusclesholder.setOnClickListener(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editProfileActivity:Button = view.findViewById(R.id.edit_profile)
        editProfileActivity.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
    override fun onClick(v: View) {
//        when (v?.id) {
//            R.id.edit_profile -> {
//                val moveIntent = Intent(this@ProfileFragment, EditProfileActivity::class.java)
//                startActivity(moveIntent)
//
//            }

        }
    }