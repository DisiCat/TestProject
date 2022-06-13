package com.example.testproject.network

import com.example.testproject.parseModels.ResultParseModel
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApiService {

    @Headers("Content-Type: application/json")
    @POST("login")
    suspend fun getUserData(@Body request:RequestBody) : Response<ResultParseModel>
}