package com.Capstone.capstoneproject.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Capstone.capstoneproject.menu.BuyWhiskas
import com.Capstone.capstoneproject.databinding.FragmentHomeBinding
import com.Capstone.capstoneproject.menu.AdoptPersianActivity
import com.Capstone.capstoneproject.menu.BritishShorthairActivity
import com.Capstone.capstoneproject.menu.BuyRoyalCaninActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupAction()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }


    @SuppressLint("ResourceType")
    private fun setupAction() {
        binding?.let { bind ->
            bind.btnRegister.setOnClickListener {
                startActivity((Intent(requireActivity(), BuyWhiskas::class.java)))
            }
        }
        binding?.let { bind ->
            bind.btnImageView4.setOnClickListener {
                startActivity((Intent(requireActivity(), BuyRoyalCaninActivity::class.java)))
            }
        }
        binding?.let { bind ->
            bind.btnImageView1.setOnClickListener {
                startActivity((Intent(requireActivity(), AdoptPersianActivity::class.java)))
            }
        }
        binding?.let { bind ->
            bind.btnImageView2.setOnClickListener {
                startActivity((Intent(requireActivity(), BritishShorthairActivity::class.java)))
            }

        }
    }
}