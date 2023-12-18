package com.Capstone.capstoneproject.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.Capstone.capstoneproject.ui.Camera.KameraFragment
import com.Capstone.capstoneproject.ui.ProfileFragment
import com.Capstone.capstoneproject.R
import com.Capstone.capstoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.page_1 -> replaceFragment(HomeFragment())
                R.id.page_2 -> replaceFragment(KameraFragment())
                R.id.page_3 -> replaceFragment(ProfileFragment())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}