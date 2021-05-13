package ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaceAPI

import retrofit2.http.*
import retrofit2.Call
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMovie

interface RetrofitServicesTest {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<TestMovie>>
}