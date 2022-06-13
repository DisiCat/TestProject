package com.example.testproject.observerUseCase

import com.example.testproject.enums.EResultType
import kotlinx.coroutines.flow.Flow

interface IAuthObserverUseCase {
    suspend fun subscribeToken(): Flow<EResultType>
}
