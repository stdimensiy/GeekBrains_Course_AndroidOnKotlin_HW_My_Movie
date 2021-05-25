package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI.RetrofitServicesTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI.RetrofitServicesTest
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClient
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClientTMDB

object Common {
    private const val BASE_URL_TEST = "https://www.simplifiedcoding.net/demos/"
    private const val BASE_URL_TMDB = "https://api.themoviedb.org/"
    val retrofitServiceTest: RetrofitServicesTest
        get() {
            return RetrofitClient.getClient(BASE_URL_TEST).create(RetrofitServicesTest::class.java)
        }

    val retrofitServiceTMDB: RetrofitServicesTMDB
        get() {
            return RetrofitClientTMDB.getClient(BASE_URL_TMDB)
                .create(RetrofitServicesTMDB::class.java)
        }
}