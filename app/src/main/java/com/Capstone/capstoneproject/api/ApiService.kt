package com.Capstone.capstoneproject.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("/")
    fun getresponse(
        @Part file: MultipartBody.Part,
    ): Call<ClassificationResponse>
}