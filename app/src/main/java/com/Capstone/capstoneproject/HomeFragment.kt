package com.Capstone.capstoneproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.navigation.fragment.findNavController
import com.Capstone.capstoneproject.databinding.FragmentHomeBinding
import com.Capstone.logined.LoginViewModel

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
        _binding = null
    }


    private fun setupAction() {
        binding?.let { bind ->
            bind.btnRegister.setOnClickListener {
                findNavController().navigate(R.id.buy_item)
            }
        }
    }

}