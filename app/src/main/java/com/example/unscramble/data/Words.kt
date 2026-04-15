package com.example.unscramble.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "custom_words")
data class Words (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String
)