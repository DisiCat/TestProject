package com.example.testproject.di

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
}