package com.Capstone.capstoneproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.Capstone.capstoneproject.databinding.FragmentProfileBinding
import kotlinx.coroutines.Dispatchers.Main


class ProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var btnIntent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnIntent = view.findViewById(R.id.btn_edit_profile)
        btnIntent.setOnClickListener(this)

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }




}