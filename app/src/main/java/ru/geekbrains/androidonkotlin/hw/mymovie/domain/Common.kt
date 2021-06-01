package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClientTmdb

object Common {
    private const val BASE_URL_TMDB = "https://api.themoviedb.org/"

    val retrofitServiceTmdb: RetrofitServicesTmdb
        get() {
            return RetrofitClientTmdb.getClient(BASE_URL_TMDB)
                .create(RetrofitServicesTmdb::class.java)
        }
}