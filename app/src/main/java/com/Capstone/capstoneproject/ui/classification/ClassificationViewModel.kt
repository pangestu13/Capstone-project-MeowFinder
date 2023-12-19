package com.Capstone.capstoneproject.ui.classification

import android.app.Application
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Capstone.capstoneproject.api.ApiConfig
import com.Capstone.capstoneproject.api.JsonMember4
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uriToFile

class ClassificationViewModel(private val  application: Application): ViewModel(){
    val imageUri = MutableLiveData<String>()
    fun classification(){

        imageUri.value?.let {
            val imageFile = uriToFile(it.toUri(), application)

            val reqFile = MultipartBody.Part.createFormData(
                "file",
                imageFile.name,
                imageFile.asRequestBody("image/jpg".toMediaType())
            )

            val client = ApiConfig.getApiService().getresponse(reqFile)

            client.enqueue(object : Callback<JsonMember4> {
                override fun onResponse(
                    call: Call<JsonMember4>,
                    response: Response<JsonMember4>
                ) {
                    if (response.isSuccessful) {
                        Log.i("berhasil", "Success : ${response.body()}")

                    } else {
                        Log.e("berhasil", "Error ${response.code()}: ${response.errorBody()?.string()}")

                    }
                }

                override fun onFailure(call: Call<JsonMember4>, t: Throwable) {
                    Log.e("berhasil", t.message.toString())

                }

            })
        }
    }
}