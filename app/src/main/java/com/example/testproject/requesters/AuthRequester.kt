package com.example.testproject.requesters

import com.example.testproject.network.RestApiService
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

class AuthRequester @Inject constructor(
    private val restApiService: RestApiService
) : IAuthRequester {

    override suspend fun loginByCredential(
        country_code: String,
        phone: String,
        pass: String
    ) {
        val jObj = JSONObject()
        jObj.put("phone_code", country_code)
        jObj.put("phone_number", phone)
        jObj.put("password", pass)
        val mediaType = "application/json; charset=utf-8".toMediaType()

        val body: RequestBody = jObj.toString().toRequestBody(mediaType)
        val requst = restApiService.getUserData(body)

        var tedt = requst.body()

        var test = tedt

    }
}