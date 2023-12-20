package com.Capstone.capstoneproject.ui.classification


import android.app.Application
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Capstone.capstoneproject.api.ApiConfig
import com.Capstone.capstoneproject.api.ClassificationResponse
import com.Capstone.capstoneproject.api.Kucing
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uriToFile

class ClassificationViewModel(private val application: Application) : ViewModel() {
    val imageUri = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    val result = MutableLiveData<Kucing>()

    fun classification(image: String) {
        isLoading.value = true
        val imageFile = uriToFile(image.toUri(), application)

        val reqFile = MultipartBody.Part.createFormData(
            "file",
            imageFile.name,
            imageFile.asRequestBody("image/jpg".toMediaType())
        )

        val client = ApiConfig.getApiService().getresponse(reqFile)

        client.enqueue(object : Callback<ClassificationResponse> {
            override fun onResponse(
                call: Call<ClassificationResponse>,
                response: Response<ClassificationResponse>
            ) {
                isLoading.value = false
                if (response.isSuccessful) {
                    Log.i("ClassificationViewModel", "Success : ${response.body()}")
                    response.body()?.let { resBody ->
                        result.value = resBody.data[0]
                    }
                } else {
                    Log.e(
                        "ClassificationViewModel",
                        "Error ${response.code()}: ${response.errorBody()?.string()}"
                    )

                }
            }

            override fun onFailure(call: Call<ClassificationResponse>, t: Throwable) {
                Log.e("ClassificationViewModel", t.message.toString())
                isLoading.value = false
            }

        })
    }
}