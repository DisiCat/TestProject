package com.example.testproject.repositories

import com.example.testproject.db.TipsDatabase
import com.example.testproject.entity.UserModel
import com.example.testproject.enums.EResultType
import com.example.testproject.localApi.ILocalApi
import com.example.testproject.mappers.toUserModel
import com.example.testproject.requesters.IAuthRequester
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val requester: IAuthRequester,
    private val database: TipsDatabase,
    private val localApi: ILocalApi

) : IAuthRepository {

    private val _msgToken = MutableSharedFlow<EResultType>()
    override val msgToken: SharedFlow<EResultType> = _msgToken.asSharedFlow()

    override suspend fun auth(code: String, phone: String, pass: String) {

        try {
            val response = requester.loginByCredential(code, phone, pass)

            if (response.isSuccessful) {
                val user: UserModel? = response.body()?.user?.toUserModel()

                user?.let {
                    database.clientDao().insert(user)
                    localApi.saveClientId(user.id)
                }
                _msgToken.emit(EResultType.SUCCESS)
            } else {

                _msgToken.emit(EResultType.ERROR)
            }

        } catch (e: Exception) {
            _msgToken.emit(EResultType.ERROR)
        }

    }
}