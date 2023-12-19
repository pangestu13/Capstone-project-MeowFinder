package com.Capstone.capstoneproject.api

import com.google.gson.annotations.SerializedName

data class Responser(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class Data(

	@field:SerializedName("4")
	val jsonMember4: JsonMember4? = null
)

data class JsonMember4(

	@field:SerializedName("Ras")
	val ras: String? = null,

	@field:SerializedName(" foto")
	val foto: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)
