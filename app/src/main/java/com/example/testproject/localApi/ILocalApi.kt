package com.example.testproject.localApi

interface ILocalApi {
    fun getClientId(): Int?
    fun saveClientId(_clientId: Int?)
}
