package com.mario.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(@SerializedName("data") val data: T? = null) : ErrorResponse()