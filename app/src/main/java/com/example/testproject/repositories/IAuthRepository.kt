package com.example.testproject.repositories

import com.example.testproject.enums.EResultType
import kotlinx.coroutines.flow.SharedFlow

interface IAuthRepository {
    suspend fun auth(code: String, phone: String, pass: String)
    val msgToken: SharedFlow<EResultType>
}
