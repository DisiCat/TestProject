package com.example.testproject.di

import com.example.testproject.localApi.ILocalApi
import com.example.testproject.localApi.LocalApi
import com.example.testproject.observerUseCase.AuthObserverUseCase
import com.example.testproject.observerUseCase.IAuthObserverUseCase
import com.example.testproject.repositories.AuthRepository
import com.example.testproject.repositories.ClientRepository
import com.example.testproject.repositories.IAuthRepository
import com.example.testproject.repositories.IClientRepository
import com.example.testproject.requesters.AuthRequester
import com.example.testproject.requesters.IAuthRequester
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppInterfacesModule {
    //Requesters
    @Binds
    abstract fun bindAuthRequester(impl: AuthRequester): IAuthRequester

    //ObserverUseCases
    @Binds
    abstract fun bindAuthObserverUseCase(impl: AuthObserverUseCase): IAuthObserverUseCase

    //Repositories
    @Binds
    abstract fun bindAuthRepository(impl: AuthRepository): IAuthRepository

    @Binds
    abstract fun bindClientRepository(impl: ClientRepository): IClientRepository

    //LocalApi
    @Binds
    abstract fun bindLocalApi(impl: LocalApi): ILocalApi

}