package com.example.testproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testproject.db.dao.ClientDao
import com.example.testproject.db.entity.UserModel

@Database(
    entities = [UserModel::class],
    version = 1,
    exportSchema = false
)

abstract class TipsDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao

    companion object {
        @Volatile
        private var INSTANCE: TipsDatabase? = null

        fun getInstance(context: Context): TipsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, TipsDatabase::class.java, "Gif.db")
                .build()
    }
}