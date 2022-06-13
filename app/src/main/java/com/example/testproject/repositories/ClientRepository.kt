package com.example.testproject.repositories

import com.example.testproject.db.TipsDatabase
import com.example.testproject.entity.UserModel
import com.example.testproject.localApi.ILocalApi
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val database: TipsDatabase,
    private val localApi: ILocalApi
) : IClientRepository {
    override suspend fun getClientById(): UserModel? {
        var result: UserModel? = null
        val clientId = localApi.getClientId()

        clientId?.let {
            result = database.clientDao().getClientById(clientId)
        }

        return result
    }
}