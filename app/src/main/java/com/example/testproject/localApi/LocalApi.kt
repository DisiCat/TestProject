package com.example.testproject.localApi

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalApi @Inject constructor() : ILocalApi {
    private var clientId: Int? = null
    override fun getClientId(): Int? {
        return clientId
    }

    override fun saveClientId(_clientId: Int?) {
        clientId = _clientId
    }
}