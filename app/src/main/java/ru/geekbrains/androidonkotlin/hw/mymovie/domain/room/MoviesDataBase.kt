package ru.geekbrains.androidonkotlin.hw.mymovie.domain.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SearchHistory::class], version = 1, exportSchema = false)
abstract class MoviesDataBase : RoomDatabase(){
    abstract fun historyDao(): HistoryDao
}
