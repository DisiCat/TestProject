package com.example.testproject.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testproject.db.entity.UserModel

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(client: UserModel)

    @Query("SELECT * FROM userData WHERE id = :clientId")
    suspend fun getClientById(clientId: String)
}