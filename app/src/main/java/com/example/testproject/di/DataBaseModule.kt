package com.example.testproject.di

import android.content.Context
import com.example.testproject.db.TipsDatabase
import com.example.testproject.db.dao.ClientDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideTipsDataBase(@ApplicationContext context: Context):TipsDatabase {
        return TipsDatabase.getInstance(context)
    }

    @Provides
    fun provideClientDao(tipsDatabase: TipsDatabase): ClientDao {
        return tipsDatabase.clientDao()
    }
}