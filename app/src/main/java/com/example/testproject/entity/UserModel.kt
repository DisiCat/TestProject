package com.example.testproject.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userData")
data class UserModel(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "phone_number") var phoneNumber: String? = null,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "second_name") var secondName: String? = null,


)
