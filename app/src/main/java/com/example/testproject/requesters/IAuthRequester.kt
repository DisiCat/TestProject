package com.example.testproject.requesters

import com.example.testproject.parseModels.ResultParseModel
import retrofit2.Response

interface IAuthRequester {
    suspend fun loginByCredential(country_code: String, phone: String, pass: String) : Response<ResultParseModel>
}