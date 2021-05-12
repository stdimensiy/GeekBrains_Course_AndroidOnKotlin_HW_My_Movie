package ru.geekbrains.androidonkotlin.hw.mymovie.domain.`interface`

import retrofit2.http.*
import retrofit2.Call
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMovie

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<TestMovie>>
}