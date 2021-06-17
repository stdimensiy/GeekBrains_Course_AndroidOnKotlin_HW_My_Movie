package ru.geekbrains.androidonkotlin.hw.mymovie.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchHistory(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val searchQuery: String
)
