package com.example.testproject.requesters

import com.example.testproject.network.RestApiService
import com.example.testproject.parseModels.ResultParseModel
import kotlinx.coroutines.coroutineScope
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
    ): retrofit2.Response<ResultParseModel> = coroutineScope {
        val jObj = JSONObject()
        jObj.put("phone_code", country_code)
        jObj.put("phone_number", phone)
        jObj.put("password", pass)
        val mediaType = "application/json; charset=utf-8".toMediaType()

        val body: RequestBody = jObj.toString().toRequestBody(mediaType)

        return@coroutineScope restApiService.getUserData(body)
    }
}