package com.example.testproject.observerUseCase

import com.example.testproject.repositories.IAuthRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthObserverUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) : IAuthObserverUseCase {

    override suspend fun subscribeToken() = flow {
        authRepository.msgToken.collect {
            emit(it)
        }
    }
}