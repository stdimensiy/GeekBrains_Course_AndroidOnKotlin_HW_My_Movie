package ru.geekbrains.androidonkotlin.hw.mymovie.di

import android.app.Application
import androidx.room.Room
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.room.MoviesDataBase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Instance = this
    }

    companion object {
        private var Instance: App? = null
        private var db: MoviesDataBase? = null
        private const val DB_NAME = "MyMovies.db"

        fun getDb(): MoviesDataBase {
            if (db == null) {
                db = Room.databaseBuilder(
                    Instance!!.applicationContext, MoviesDataBase::class.java, DB_NAME
                ).build()
            }
            return db as MoviesDataBase
        }
    }
}