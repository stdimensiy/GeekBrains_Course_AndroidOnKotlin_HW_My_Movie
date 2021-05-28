package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTmdb
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api.RetrofitServicesTest
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClient
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClientTmdb

object Common {
    private const val BASE_URL_TEST = "https://www.simplifiedcoding.net/demos/"
    private const val BASE_URL_TMDB = "https://api.themoviedb.org/"
    val retrofitServiceTest: RetrofitServicesTest
        get() {
            return RetrofitClient.getClient(BASE_URL_TEST).create(RetrofitServicesTest::class.java)
        }

    val retrofitServiceTmdb: RetrofitServicesTmdb
        get() {
            return RetrofitClientTmdb.getClient(BASE_URL_TMDB)
                .create(RetrofitServicesTmdb::class.java)
        }
}