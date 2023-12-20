package com.Capstone.capstoneproject.api

import com.google.gson.annotations.SerializedName

data class ClassificationResponse(

	@field:SerializedName("data")
	val data: List<Kucing>,

	@field:SerializedName("status")
	val status: Status
)

data class Kucing(

	@field:SerializedName("Ras")
	val ras: String? = null,

	@field:SerializedName("Foto")
	val foto: String? = null,

	@field:SerializedName("Deskripsi")
	val deskripsi: String? = null
)

data class Status(
	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("message")
	val message:String
)