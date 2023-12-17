package com.Capstone.capstoneproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class KameraFragment : Fragment(), View.OnClickListener{

    private lateinit var btnIntentku: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnIntentku =  view.findViewById(R.id.btn_take_foto)
        btnIntentku.setOnClickListener(this)

    }


    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_back_home -> run{
                val intentk = Intent(requireContext(), MainActivity::class.java)
                startActivity(intentk)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kamera, container, false)
    }

}
