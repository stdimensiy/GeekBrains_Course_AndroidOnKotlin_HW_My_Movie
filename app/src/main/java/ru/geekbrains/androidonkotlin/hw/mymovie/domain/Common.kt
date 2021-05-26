package ru.geekbrains.androidonkotlin.hw.mymovie.domain

import android.util.Log
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI.RetrofitServicesTMDB
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI.RetrofitServicesTest
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClient
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClientTMDB

object Common {
    private const val BASE_URL_TEST = "https://www.simplifiedcoding.net/demos/"
    private const val BASE_URL_TMDB = "https://api.themoviedb.org/"
    val retrofitServiceTest: RetrofitServicesTest
        get() {
            Log.d("MyApp", "Вызван RetrofitServicesTest")
            return RetrofitClient.getClient(BASE_URL_TEST).create(RetrofitServicesTest::class.java)
        }

    val retrofitServiceTMDB: RetrofitServicesTMDB
        get() {
            Log.d("MyApp", "Вызван RetrofitServicesTMDB")
            return RetrofitClientTMDB.getClient(BASE_URL_TMDB)
                .create(RetrofitServicesTMDB::class.java)
        }
}