package com.example.testproject.repositories

import com.example.testproject.entity.UserModel

interface IClientRepository {
    suspend fun getClientById(): UserModel?
}
