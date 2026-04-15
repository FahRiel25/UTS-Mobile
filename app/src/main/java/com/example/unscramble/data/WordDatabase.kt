package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Words::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordDatabase? = null
        fun getDatabase(context: Context): WordDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, WordDatabase::class.java, "word_database")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}