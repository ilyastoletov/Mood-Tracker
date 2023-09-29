package com.dev.data.network

import com.dev.data.config.Routes
import com.dev.data.network.dto.RegisterDto
import com.dev.data.utils.ApiResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {

    @POST(Routes.Auth.register)
    suspend fun register(@Query("hash") hash: String): ApiResponse<RegisterDto>

    @GET(Routes.Auth.login)
    suspend fun login(@Query("token") token: String): ApiResponse<Boolean>

}