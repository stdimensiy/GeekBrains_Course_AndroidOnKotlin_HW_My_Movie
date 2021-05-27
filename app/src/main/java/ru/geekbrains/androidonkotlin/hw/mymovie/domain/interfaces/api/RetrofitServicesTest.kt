package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.api

import retrofit2.Call
import retrofit2.http.GET
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMovie

interface RetrofitServicesTest {
    @GET("marvel")
    fun getMovieList(): Call<List<TestMovie>>
}