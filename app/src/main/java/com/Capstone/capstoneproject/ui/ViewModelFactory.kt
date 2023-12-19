package com.Capstone.capstoneproject.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.Capstone.capstoneproject.ui.classification.ClassificationViewModel

    class ViewModelFactory private constructor(private val application: Application) :
        ViewModelProvider.NewInstanceFactory() {
        companion object {
            @Volatile
            private var INSTANCE: ViewModelFactory? = null

            @JvmStatic
            fun getInstance(application: Application): ViewModelFactory {
                if (INSTANCE == null) {
                    synchronized(ViewModelFactory::class.java) {
                        INSTANCE = ViewModelFactory(application)
                    }
                }
                return INSTANCE as ViewModelFactory
            }
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            when {

                (modelClass.isAssignableFrom(ClassificationViewModel::class.java)) -> {
                    return ClassificationViewModel(application) as T
                }
            }
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }