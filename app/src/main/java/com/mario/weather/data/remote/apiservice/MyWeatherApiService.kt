package com.mario.weather.data.remote.apiservice

import com.mario.weather.data.model.AppInfo
import com.mario.weather.data.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyWeatherApiService {
    @FormUrlEncoded
    @POST("common/app_info")
    fun appInfo(@Field("dev_type") dev_type: String): Flow<BaseResponse<AppInfo>>
}