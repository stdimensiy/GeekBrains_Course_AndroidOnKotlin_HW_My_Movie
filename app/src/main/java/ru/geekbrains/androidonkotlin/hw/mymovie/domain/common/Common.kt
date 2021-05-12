package ru.geekbrains.androidonkotlin.hw.mymovie.domain.common

import ru.geekbrains.androidonkotlin.hw.mymovie.domain.`interface`.RetrofitServices
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitServices
        get() {
            return RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
        }
}