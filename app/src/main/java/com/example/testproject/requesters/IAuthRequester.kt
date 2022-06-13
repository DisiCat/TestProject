package com.example.testproject.requesters

interface IAuthRequester {
    suspend fun loginByCredential(country_code: String, phone: String, pass: String)
}